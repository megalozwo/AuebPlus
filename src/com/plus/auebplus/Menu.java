package com.plus.auebplus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Menu extends Activity {
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menuscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView eclass = (ImageView) findViewById(R.id.eclass);
        ImageView grades = (ImageView) findViewById(R.id.grades);
        ImageView strikes = (ImageView) findViewById(R.id.strikes);
        ImageView news = (ImageView) findViewById(R.id.news);
        ImageView schedules = (ImageView) findViewById(R.id.schedule);
        ImageView map = (ImageView) findViewById(R.id.map);
        ImageView access = (ImageView) findViewById(R.id.access);
        ImageView announcements = (ImageView) findViewById(R.id.announcements);
        ImageView secretary = (ImageView) findViewById(R.id.secretary);
        
        
        
        
        secretary.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
		        	 Intent mainIntent = new Intent(Menu.this,Secretary.class);
		                Menu.this.startActivity(mainIntent);
				
			}
		});
        
        announcements.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
		        	 Intent mainIntent = new Intent(Menu.this,Announcements.class);
		                Menu.this.startActivity(mainIntent);
		        }
				
			}
		});
        
        access.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent mainIntent = new Intent(Menu.this,Access.class);
	                Menu.this.startActivity(mainIntent);
			}
		});
        
        map.setOnClickListener(new OnClickListener (){
        	
        	@Override
            public void onClick(View v) {
        		if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
        		/* Create an Intent that will start the SchedulesActivity. */
                Intent mainIntent = new Intent(Menu.this,Map.class);
                Menu.this.startActivity(mainIntent);
		        }
        	}
        });
        
        
        schedules.setOnClickListener(new OnClickListener (){
        	@Override
            public void onClick(View v) {
        		if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
        		/* Create an Intent that will start the SchedulesActivity. */
                Intent mainIntent = new Intent(Menu.this,SchedulesActivity.class);
                Menu.this.startActivity(mainIntent);
		        }
        	}
        });
        

        
        eclass.setOnClickListener(new OnClickListener (){
        	@Override
            public void onClick(View v) {
        		if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
        		/* Create an Intent that will start the WebView-Activity. */
                Intent mainIntent = new Intent(Menu.this,WebViewActivity.class);
                mainIntent.putExtra("siteName","https://eclass.aueb.gr/index.php");
                //EDIT:Menu.this.startActivity(mainIntent); ps. To allaksa se ola apo ta parakatw se aplo "startActivity()"
                startActivity(mainIntent);
		        }
        	}
        });
        
        grades.setOnClickListener(new OnClickListener (){
        	@Override
            public void onClick(View v) {
        		if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
        		/* Create an Intent that will start the WebView-Activity. */
                Intent mainIntent = new Intent(Menu.this,WebViewActivity.class);
                mainIntent.putExtra("siteName","http://e-grammateia.aueb.gr/unistudent/?lang=el-gr");
                startActivity(mainIntent);
		        }
        	}
        });
        
        strikes.setOnClickListener(new OnClickListener (){
        	@Override
            public void onClick(View v) {
        		if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
        		/* Create an Intent that will start the WebView-Activity. */
                Intent mainIntent = new Intent(Menu.this,WebViewActivity.class);
                mainIntent.putExtra("siteName","http://apergia.gr/q/");
                startActivity(mainIntent);
		        }
        	}
        });
        
        news.setOnClickListener(new OnClickListener (){
        	@Override
            public void onClick(View v) {
        		if(!isNetworkAvailable()){
		        	showAlertDialog();
		        }else{
        		/* Create an Intent that will start the WebView-Activity. */
                Intent mainIntent = new Intent(Menu.this,News.class);
                mainIntent.putExtra("uri1", "http://www.aueb.gr/pages/news/RSS/anakoinoseis_home.xml");
                mainIntent.putExtra("uri2", "http://news.yahoo.com/rss/entertainment");
                startActivity(mainIntent);
		        }
        	}
        });
    }
    
    private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
    
    public void showAlertDialog(){
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Menu.this);
 
			// set title
			alertDialogBuilder.setTitle("Aueb Plus");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Aueb+ has detected that your device currently has no Internet connection. Make sure that" +
						" your device is connected to the internet and try again.")
				.setCancelable(false)
				.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// the dialog
					}
				  });
				AlertDialog alert = alertDialogBuilder.create();
				alert.show();
			}
    

}
