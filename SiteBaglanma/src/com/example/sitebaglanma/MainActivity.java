package com.example.sitebaglanma;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	static EditText adEditText;
	static EditText sifreEditText;
	static Button girisButon;
	static ProgressDialog dialogs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adEditText = (EditText) findViewById(R.id.username);
		sifreEditText = (EditText) findViewById(R.id.password);
		girisButon = (Button) findViewById(R.id.button1);
		new BackRoundClass().execute("post_id", "user_id");
		girisButon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("hello");
				dialogs = new ProgressDialog(MainActivity.this);
						dialogs.setMessage("Giriş Yapılıyor..");
						dialogs.show();
				if (adEditText.getText().toString() == BackRoundClass.post_ID && sifreEditText.getText().toString() == BackRoundClass.user_ID) {
					Toast.makeText(getApplicationContext(), "Giriş Başarılı", Toast.LENGTH_LONG).show();
					dialogs.dismiss();
				}
				
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
