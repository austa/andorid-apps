package com.example.volleyproject;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ApplicationErrorReport.AnrInfo;
import android.content.Context;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final String URL = "http://gdata.youtube.com/feeds/api/users/cnnturk/uploads?v=2&alt=jsonc&start-index=1&max-results=30";
	ListView listview;
	Activity context;
	final List<Video> misona = new ArrayList<Video>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		listview = (ListView) findViewById(R.id.listView1);
		//final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, misona);
		//listview.setAdapter(adapter);
		
		RequestQueue rq = Volley.newRequestQueue(context);
		JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, URL, null, 
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						try {
							
							JSONArray videos = response.getJSONObject("data").getJSONArray("items");
							for (int i = 0; i < videos.length(); i++) {
								misona.add(new Video(videos.getJSONObject(i).getString("title"), videos.getJSONObject(i).getString("thumbnail")));
							}
						} catch (JSONException e) {
							
							e.printStackTrace();
						}
						
						SpecialAdapter adapter = new SpecialAdapter(context, misona);
						adapter.notifyDataSetChanged();
						listview.setAdapter(adapter);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
					Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
				
					}
			
		});
		
		rq.add(jsonRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
