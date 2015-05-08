package com.plus.auebplus;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class SecretaryViewer extends Activity {

	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		Intent myIntent= getIntent(); // gets the previously created intent
		int layout = myIntent.getIntExtra("layout", 0);
		setContentView(layout);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
	}
	
}
