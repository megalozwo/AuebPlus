package com.plus.auebplus;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.plus.auebplus.rss.Message;
import com.plus.auebplus.rss.ScheduleListAdapter;

public class SchedulesActivity extends ListActivity {
	List<Message> listURL = new ArrayList<Message>();
	Context context;
	
	ScheduleListAdapter fla;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    listURL=initList();
	    context=this;

	    ListView lv = getListView();
	    fla = new ScheduleListAdapter(this, listURL);
	    lv.setAdapter(fla);
	    
	    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	         public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
	                                 long id) {

	        	 Intent i =new Intent(context,WebViewActivity.class);
	 		 	i.putExtra("siteName",listURL.get(position).getDescription());
	 			context.startActivity(i);    
	         }
	    });
	}
	
	   private List<Message> initList() {
		   Message msg1 = new Message();
		   msg1.setTitle("Πρόγραμμα Εξεταστικής");msg1.setDescription("https://dl.dropboxusercontent.com/u/3038853/full_programma.pdf");
		   listURL.add(msg1); Message msg2 = new Message();
		   msg2.setTitle("Οικονομικής Επιστήμης");msg2.setDescription("https://dl.dropboxusercontent.com/u/3038853/oikonomiki_epistimi.pdf");
		   listURL.add(msg2); Message msg3 = new Message();
		   msg3.setTitle("Διεθνών και Ευρωπαϊκών");msg3.setDescription("https://dl.dropboxusercontent.com/u/3038853/die8nwn.pdf");
		   listURL.add(msg3); Message msg4 = new Message();
		   msg4.setTitle("Οργάνωσης και Διοίκησης");msg4.setDescription("https://dl.dropboxusercontent.com/u/3038853/ode.pdf");
		   listURL.add(msg4); Message msg5 = new Message();
		   msg5.setTitle("Μάρκετινγκ");msg5.setDescription("https://dl.dropboxusercontent.com/u/3038853/marketing.pdf");
		   listURL.add(msg5); Message msg6 = new Message();
		   msg6.setTitle("Λογιστικής");msg6.setDescription("https://dl.dropboxusercontent.com/u/3038853/logistiki.pdf");
		   listURL.add(msg6); Message msg7 = new Message();
		   msg7.setTitle("Διοικητικής Επιστήμης");msg7.setDescription("https://dl.dropboxusercontent.com/u/3038853/det.pdf");
		   listURL.add(msg7); Message msg8 = new Message();
		   msg8.setTitle("Πληροφορικής");msg8.setDescription("https://dl.dropboxusercontent.com/u/3038853/pliroforiki.pdf");
		   listURL.add(msg8); Message msg9 = new Message();
		   msg9.setTitle("Στατιστικής");msg9.setDescription("https://dl.dropboxusercontent.com/u/3038853/statistiki.pdf");
		   listURL.add(msg9);
		   return listURL;


		}
	   

}
