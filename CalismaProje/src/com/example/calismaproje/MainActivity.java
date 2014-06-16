package com.example.calismaproje;

import android.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int ID_GUNCELLE = Menu.FIRST;
	private static final int ID_GERI_DON = Menu.FIRST + 1;
	private static final int ID_DAHA_FAZLA = Menu.FIRST +2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		menu.add(Menu.NONE, ID_GERI_DON, 0, "Geri Dön");
		menu.add(menu.NONE, ID_GUNCELLE, 1, "Güncelle");
		SubMenu subMenu = menu.addSubMenu(Menu.NONE, ID_DAHA_FAZLA, 3, "Daha Fazla");
		subMenu.add(menu.NONE, Menu.NONE, 4, "Seçenekler");
		
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ID_GERI_DON:
			Toast.makeText(getApplicationContext(), "Geri Dönülüyor", Toast.LENGTH_LONG).show();
			return true;
		case ID_GUNCELLE:
			Toast.makeText(getApplicationContext(), "Güncelle", Toast.LENGTH_LONG).show();
			return true;
		case ID_DAHA_FAZLA:
			Toast.makeText(getApplicationContext(), "Daha Fazla", Toast.LENGTH_LONG).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}	
	}
}
