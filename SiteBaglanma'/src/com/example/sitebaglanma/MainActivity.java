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

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Entity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	final static String URI = "http://gameparks.org";
	private static TextView tv1;
	//JSONObject json;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new BackGround().execute("text");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected JSONObject connection() throws ClientProtocolException, IOException, JSONException{
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
	
	public class BackGround extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... params) {
			try {
				String first_data = connection().getString(params[0]);
				//String second_data = connection().getString(params[1]);
				return first_data;
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String first_data) {
			Intent intent = new Intent(getApplicationContext(), LoginClass.class);
			intent.putExtra("veri", first_data);
			//intent.putExtra("veri1", second_data);
			startActivity(intent);
			super.onPostExecute(first_data);
		}
		
		
	}

}
