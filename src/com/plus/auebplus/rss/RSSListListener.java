package com.plus.auebplus.rss;

import java.util.List;

import com.plus.auebplus.WebViewActivity;


import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


/**
 * Class implements a list listener
 * 
 * @author ITCuties
 *
 */
public class RSSListListener implements OnItemClickListener {

	// List item's reference
	List<Message> listItems;
	// Calling activity reference
	Activity activity;
	
	public RSSListListener(List<Message> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity  = anActivity;
	}
	
	/**
	 * Start a browser with url from the rss item.
	 */
	
	 public void onItemClick(AdapterView<?> parent, View view,
             int position, long id) {
		 Intent i =new Intent(activity,WebViewActivity.class);
		 	//System.out.println(messages.get(position).getLink().toString());
		 	i.putExtra("siteName",listItems.get(position).getLink().toString());
			//i.setData(Uri.parse(messages.get(position).getLink().toString()));
			activity.startActivity(i);    
         }
            
	
}
