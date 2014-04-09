package com.aletus.mailgonderme;

import com.aletus.mailgonderme.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailGonderme extends Activity {
	private static final int ID_GERI = Menu.FIRST;
	private static final int ID_HAKKAINDA = Menu.FIRST + 1;
	
	private EditText aliciEtd;
	private EditText konuEdt;
	private EditText govdeEdt;
	private Button gonderBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aliciEtd = (EditText) findViewById(R.id.aliciEdit);
		konuEdt = (EditText) findViewById(R.id.konuEdit);
		govdeEdt = (EditText) findViewById(R.id.govdeEdit);
		gonderBtn = (Button) findViewById(R.id.gonderBtn);
		
		gonderBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				sendEmail();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(menu.NONE, ID_HAKKAINDA, 0, "Hakkında");
		menu.add(menu.NONE, ID_GERI, 1, "Geri");
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == ID_HAKKAINDA) {
			System.exit(0);
		}else if (item.getItemId() == ID_GERI) {
			Toast.makeText(getApplicationContext(), "gerii", Toast.LENGTH_LONG).show();
		}
		return super.onOptionsItemSelected(item);
	}

	protected void sendEmail() {

	      String[] alicilar = {aliciEtd.getText().toString()};
	      Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
	      email.setType("message/rfc822");

	      email.putExtra(Intent.EXTRA_EMAIL, alicilar);
	      email.putExtra(Intent.EXTRA_SUBJECT, konuEdt.getText().toString());
	      email.putExtra(Intent.EXTRA_TEXT, govdeEdt.getText().toString());

	      try {
		    
	    	  startActivity(Intent.createChooser(email, "Göndereceğiniz hesap türünü seçiniz."));
	     
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(MailGonderme.this, "Email gönderme başarısız.",
	        		 Toast.LENGTH_LONG).show();
	      }
	   }

}
