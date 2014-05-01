package com.example.webviewproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {
	WebView webview;
	ProgressDialog diyalog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webview = (WebView) findViewById(R.id.webView1);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("https://facebook.com");
		
		diyalog = ProgressDialog.show(this, "Facebook", "Yükleniyor..", true);
		diyalog.show();
		webview.setWebViewClient(new WebViewClient(){
			@Override
	         public void onPageFinished(WebView view, String url) {
	            super.onPageFinished(view, url);
	            Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
	            diyalog.dismiss();
	         }
	 
	         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
	            Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
	            diyalog.dismiss();
	         }
	      });		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
