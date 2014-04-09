package com.example.adaptercalisma;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {
	private Spinner spn;
	private String[] isimler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spn = (Spinner) findViewById(R.id.spinner1);
		isimler = getResources().getStringArray(R.array.names);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_iller, isimler);
		spn.setOnItemSelectedListener(this);
		spn.setAdapter(adapter);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int position,
			long id) {
		
        String secilenDeger = spn.getItemAtPosition(position).toString();
        
        Toast.makeText(this, secilenDeger, Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
