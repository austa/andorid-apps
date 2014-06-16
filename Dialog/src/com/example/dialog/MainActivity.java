package com.example.dialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button kaydetButon;
	private Button	progressButon;
	private String[] isimler;
	//Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		isimler = getResources().getStringArray(R.array.insan_adi);
		kaydetButon = (Button) findViewById(R.id.button1);
		progressButon = (Button) findViewById(R.id.button2);
		progressButon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProgressDialog.show(MainActivity.this, "","işlem oluyor bekle", true, true);
				
			}
		});
		kaydetButon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Doğrulama");
				builder.setMessage("Kaydetmek istediğinizden emin misiniz ?");
				builder.setItems(isimler, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(),which, Toast.LENGTH_LONG).show();
						
					}
				});
				builder.setPositiveButton(R.string.evet, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(), "Veriler kayır ediliyor", Toast.LENGTH_LONG).show();						
					}
				});
				builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						
					}
				});
				AlertDialog alertDialog = builder.create();
				alertDialog.show();
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
