package com.plus.auebplus;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.plus.auebplus.rss.FeedListAdapter;
import com.plus.auebplus.rss.Message;
import com.plus.auebplus.rss.MyCustomFeedParser;
import com.plus.auebplus.rss.RSSListListener;

public class Announcements extends ListActivity{
	
	public ProgressDialog progDailog; 

	public static List<Message> messages= new ArrayList<Message>();
	public Activity activity;
	
    public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     this.activity=this;
     
     progDailog = ProgressDialog.show(this, "Loading","Please wait...", true);
     progDailog.setCancelable(true);
     
     GetRSSDataTask task = new GetRSSDataTask(this);
		
		// Start download RSS task
		task.execute("http://www.aueb.gr/pages/news/RSS/anakoinoseis_home.xml");
        
     
    }
    
    public void showAlertDialog(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				activity);
 
			// set title
		// REMOVE THE EXTRA STRING AFTER TEST
			alertDialogBuilder.setTitle("Aueb Plus");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("An error occured while retrieve the RSS feed from http://www.aueb.gr. Please try again later or restart your network connection.")
				.setCancelable(false)
				.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// the dialog
						activity.finish();
					}
				  });
				AlertDialog alert = alertDialogBuilder.create();
				alert.show();
			}
}
    
    
    class GetRSSDataTask extends AsyncTask<String, Void, List<Message> > {
	
    	private Announcements activity;
    	
    	public GetRSSDataTask(Announcements a){
    		super();
    		this.activity=a;
    	}
    	
		//choco
		protected List<Message> doInBackground(String... urls) {
			boolean parsedstuff = false;
			boolean connected=false;
			while(!parsedstuff){
				try {
					// Create RSS reader
					// System.out.println(urls[0]);
					while(!connected){
						 MyCustomFeedParser parser = new MyCustomFeedParser(urls[0]);
						 parsedstuff=true;
						// Parse RSS, get items
						 if(!parser.parse().isEmpty()){
							 connected=true;
							 return parser.parse();
						 }
					}
				} catch (Exception e) {
					//Log.e("RSS parsing failed", e.getMessage());
				}
			}
			
			
			return null;
		}
		
		@Override
		protected void onPostExecute(List<Message> result) {
			if(result!=null){
				if(result.isEmpty()){
					activity.showAlertDialog();
				}else{
					if(activity.progDailog!=null){
						activity.progDailog.dismiss();
					}	
					FeedListAdapter fa = new FeedListAdapter(activity, result);
					ListView list1 = activity.getListView();
					list1.setAdapter(fa);
					
					list1.setOnItemClickListener(new RSSListListener(result,activity));
				}
			}else{
				activity.showAlertDialog();
			}
			
			
		
		}
		
		 
    
}

	