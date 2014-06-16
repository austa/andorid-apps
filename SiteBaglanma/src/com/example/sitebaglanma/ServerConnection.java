package com.example.sitebaglanma;

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

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class ServerConnection extends Activity{
	
	final static String URI = "http://gameparks.org";
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	protected static JSONObject ConnectionMethod() throws ClientProtocolException, IOException, JSONException{
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
