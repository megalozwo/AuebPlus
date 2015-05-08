package com.plus.auebplus;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Access extends Activity {

	ImageView button1,button2,button3;
	
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		setContentView(R.layout.access);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		button1 = (ImageView) findViewById(R.id.access1);
		button2 = (ImageView) findViewById(R.id.access2);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Access.this, AccessListOte.class);
				i.putExtra("key", 0);
				startActivity(i);
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Access.this, AccessListPan.class);
				i.putExtra("key", 1);
				startActivity(i);
			}
		});
		
	}
}
