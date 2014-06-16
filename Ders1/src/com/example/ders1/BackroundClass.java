package com.example.ders1;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.AsyncTask;

public class BackroundClass extends AsyncTask<String, String, String> {

	@Override
	protected String doInBackground(String... params) {
		try {
			MainActivity.json = MainActivity.readGameParks();
			String data = MainActivity.json.getString(params[0]);
			return data;
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
	protected void onPostExecute(String data) {
		MainActivity.tv1.setText(data);
		
	}
	

}
