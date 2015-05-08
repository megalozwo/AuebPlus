package com.plus.auebplus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends Activity {
	
	private WebView webView;
	private ProgressDialog progDailog; 

	
	 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		
		 progDailog = ProgressDialog.show(this, "Loading","Please wait...", true);
	     progDailog.setCancelable(true);
		
		
		Intent myIntent= getIntent(); // gets the previously created intent
		String siteName = myIntent.getStringExtra("siteName"); // will return "FirstKeyValue"
		 if(siteName.endsWith("pdf")){
			 siteName = "http://docs.google.com/gview?embedded=true&url=" + siteName;
         	
         }
		webView = (WebView) findViewById(R.id.webview);
		webView.setWebViewClient(new WebViewClient() {
			   //show progress bar
			   @Override
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {
	                progDailog.show();
	                view.loadUrl(url);

	                return true;                
	            }
			 
			   //dismiss progress bar
	            @Override
	            public void onPageFinished(WebView view, final String url) {
	                progDailog.dismiss();
	            }
	            //handle errors from https protocol and SSL certificates.
	            @Override
	            public void onReceivedSslError (WebView view, SslErrorHandler handler, SslError error) {
	            	 handler.proceed() ;
	            	 }
			 });
		
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setScrollbarFadingEnabled(false);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.setInitialScale(30);
		webView.loadUrl(siteName);
		
		 
	}
	

}


