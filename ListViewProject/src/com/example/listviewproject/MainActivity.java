package com.example.listviewproject;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	final List<Kisi> kisiler = new ArrayList<Kisi>(); 
	ListView listemiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		kisiler.add(new Kisi("Alaattin", false));
		kisiler.add(new Kisi("Ruziye", true));
		kisiler.add(new Kisi("Selvihan", true));
		kisiler.add(new Kisi("Oğuz Cem", false));
	
		listemiz = (ListView) findViewById(R.id.liste);
		OzelAdapter adaptorumuz = new OzelAdapter(this, kisiler);
		listemiz.setAdapter(adaptorumuz);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
