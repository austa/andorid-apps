package com.example.sitebaglanma;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class LoginClass extends Activity{
	static TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giris);
		tv1 = (TextView) findViewById(R.id.textView1);
		
		Intent y_intent = getIntent();
		Bundle gelen_veri = y_intent.getExtras();
		String icerik = gelen_veri.getString("veri");
		//String icerik1 = gelen_veri.getString("veri1");
		
		tv1.setText(icerik);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
