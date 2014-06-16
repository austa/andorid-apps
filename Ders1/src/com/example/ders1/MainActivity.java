package com.example.ders1;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	final static String URI = "http://gameparks.org";
	protected static TextView tv1;
	static JSONObject json;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.textview1);
		new BackroundClass().execute("text");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected static JSONObject readGameParks() throws ClientProtocolException, IOException, JSONException{
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(URI);
		HttpResponse response = client.execute(request);
		StatusLine status = response.getStatusLine();
		int s = status.getStatusCode();
		
		if (s == 200) {
			HttpEntity e = response.getEntity();
			String data = EntityUtils.toString(e);
			JSONArray posts = new JSONArray(data);
			JSONObject last = posts.getJSONObject(0);
			return last;
		}
		
		
		return null;
		
	}

}
