package com.plus.auebplus;

import java.util.ArrayList;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;

import com.plus.auebplus.prosvash.LazyAdapter;
import com.plus.auebplus.prosvash.TransferObject;

public class AccessListOte extends Activity{

	//List<HashMap<String, String>> listmap = new ArrayList<HashMap<String,String>>();
	ArrayList<TransferObject> listmap = new ArrayList<TransferObject>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.accesslistview);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    //Ote
	    //panellhnios.
	    final ListView listbusses = (ListView) findViewById(R.id.busses);
	    String[] names = new String[] { "b022","b054","b224","b500","b608","b622","bA8","bB8","t2","t3","t4","t5","t11","t13","t14" };
	    String[] captions = new String[] {"м.йуьекг - лаяаскеиос","пеяиссос - айадглиа - леталояжысг",
                "йаисаяиамг - ек. бемифекоу","пеияаиас - йгжисиа","цакатси - айадглиа - мейя.фыцяажоу",
                "цоудг - амы цакатси","покутевмеио - м.иымиа - лаяоуси","покутевмеио - м.жикадекжеиа - леталояжысг","амы йуьекг - пацйяати - йаисаяиамг","м.жикадекжеиа - амы патгсиа - цгяойолеио",
	    		"амы йуьекг - ац. аятелиос - ст. летяо ац. иыаммгс","калпяимг - пк.сумтацлатос - тфитфижиес",
	    		"а.патгсиа - м.пацйяати - м.екбетиа","калпяимг - пк.йамиццос - м.ьувийо",
	    		"пк.пападиаламтг - к.акенамдяас - м.ьувийо"};   
	    for(int i=0;i<names.length;i++){
	    	TransferObject to= new TransferObject();
	    	to.setName(names[i].substring(1));
	    	to.setcap(captions[i]);
	    	if(names[i].startsWith("b")){
	    		to.setbus(true);
	    	}else{
	    		to.setbus(false);
	    	}
	    	listmap.add(to);
	    	to=null;
	    	
	    }

	    final LazyAdapter adapter = new LazyAdapter(this,listmap);
	    listbusses.setAdapter(adapter);
	    listbusses.setOnItemClickListener(null);
	  }


	} 
