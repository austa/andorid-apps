package com.example.sitebaglanma;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class BackRoundClass extends AsyncTask<String, String, String> {
	JSONObject json_postId, json_userId;
	static String post_ID, user_ID;
	
	@Override
	protected String doInBackground(String... params) {
		try {
			post_ID = ServerConnection.ConnectionMethod().getString(params[0]); 
			user_ID = ServerConnection.ConnectionMethod().getString(params[1]);			
			
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
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
	}
	
	

}
