package com.example.smsandemail;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnSms, btnEmail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSms = (Button) findViewById(R.id.smsgonder);
		btnSms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String smsNumber = "05334349186";
				String smsText = "Merhaba baba, naber? ";
				Uri uri = Uri.parse("smsto:" + smsNumber);
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
				intent.putExtra("sms_body", smsText);
				startActivity(intent);
				
			}
		});
		
		btnEmail = (Button) findViewById(R.id.emailgonder);
		btnEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/html");
				
				intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"alaattin.usta@bil.omu.edu.tr"});
				intent.putExtra(Intent.EXTRA_SUBJECT, "Mail Konu Kısmı");
				intent.putExtra(Intent.EXTRA_TEXT, "Mail içeriği buradaaa!!");
				startActivity(Intent.createChooser(intent, "Send Mail?"));				
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
