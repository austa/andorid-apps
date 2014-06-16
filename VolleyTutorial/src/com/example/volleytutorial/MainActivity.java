package com.example.volleytutorial;

import com.android.volley.toolbox.ImageLoader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	 private static final String IMAGE_URL = "http://www.bahadirakin.com/wp-content/uploads/2013/10/android_volley.png";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Init Volley application --- Only Once
        final VolleyApplication volleyApplication = VolleyApplication
                .getInstance();
        volleyApplication.init(getApplicationContext());
 
        // Lazy Loading Image
        final ImageView lazyImage = (ImageView) findViewById(R.id.lazyImage);
        volleyApplication.getImageLoader().get(
                IMAGE_URL,
                ImageLoader.getImageListener(lazyImage, R.drawable.loading, R.drawable.error));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
