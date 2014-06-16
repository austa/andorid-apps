package com.example.merhabaandroid;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ListView ulkelist;
	private String[] ulkeler = {"Türkiye", "Almanya", "Avusturya", "Amerika","İngiltere",
	        "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
	        "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
	        "Makedonya", "Ukrayna", "İsviçre"};
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ulkelist = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> veriAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
		ulkelist.setAdapter(veriAdaptor);
		
		ulkelist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				AlertDialog.Builder diyalogcu = new AlertDialog.Builder(MainActivity.this);
					diyalogcu.setMessage(ulkeler[position]);
					diyalogcu.setCancelable(false);
					diyalogcu.setPositiveButton("Tamam", new OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							
						}
					});
					diyalogcu.create().show();
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
