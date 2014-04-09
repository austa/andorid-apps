package com.example.veritabani;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Veritabani v1;
	private TextView ad1;
	private TextView ad2;
	private Button kaydet;
	private Button goruntule;
	private EditText editAd;
	private EditText editSoyad;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		v1 = new Veritabani(this);
		ad1 = (TextView) findViewById(R.id.getirAd);
		ad2 = (TextView) findViewById(R.id.getirSoyad);
		kaydet = (Button) findViewById(R.id.kaydetBtn);
		goruntule = (Button) findViewById(R.id.goruntuleBtn);
		editAd = (EditText) findViewById(R.id.editAd);
		editSoyad = (EditText) findViewById(R.id.editsoyAd);
		
		kaydet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					ekleme(editAd.getText().toString(), editSoyad.getText().toString());
					Toast.makeText(getApplicationContext(), "Veritabanına kayıt oldu", Toast.LENGTH_LONG).show();
				} finally {
					v1.close();
				}
				
			}
		});
		goruntule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				bilgileriGoster();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void ekleme(String ad, String soyad){
		SQLiteDatabase db = v1.getWritableDatabase();
		ContentValues cv1 = new ContentValues();
		cv1.put("ad", ad);
		cv1.put("soyad", soyad);
		db.insertOrThrow("bilgiler", null, cv1);
			
	}
	private String[] sutunlar = {"ad","soyad"};
	
	private void bilgileriGoster(){
		SQLiteDatabase db = v1.getReadableDatabase();
		Cursor okunanlar = db.query("bilgiler", sutunlar, null, null, null, null, null);
		while (okunanlar.moveToNext()) {
			String add = okunanlar.getString(okunanlar.getColumnIndex("ad"));
			String soyad = okunanlar.getString(okunanlar.getColumnIndex("soyad"));
			ad1.setText(add);
			ad2.setText(soyad);			
		}	
	}
}
