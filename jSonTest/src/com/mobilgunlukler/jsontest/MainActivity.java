package com.mobilgunlukler.jsontest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ornek2();
    }
    
    public void ornek2(){		  
    	JSONArray array = null;
    	//Json'u string olarak internetten alıyoruz
		String restWebServerResponse = getFromInternet("http://mobilgunlukler.com/ornek/jsonOrnek2.php");
		try{  
			//Aldığımız string jsonArray türüne dönüştürüyoruz.
			array = new JSONArray(restWebServerResponse);
		}catch (JSONException e) {  
			Log.e("Hata", e.toString());
		}     
		  	         
		// Kaç adet item varsa o kadar döndürüyoruz
		for (int i = 0; i < array.length(); i++) {	   	 	   	 
			try {
				// Kaçıncı itemdeysek onun bilgisini jsonItem 
				// değişkenine atıyoruz ve gerekli işlemleri yapıyoruz.
				JSONObject jsonItem = array.getJSONObject(i);
				Log.i("Isim-"+i+":",jsonItem.getString("isim"));
				Log.i("SoyIsim-"+i+":",jsonItem.getString("soyisim"));
			} catch (JSONException e) {
				Log.e("Hata", e.toString());
			}
			
		}
    }
    
    public String getFromInternet(String url){
    	String response_str = null;
    	HttpClient client = new DefaultHttpClient();
    	HttpGet request = new HttpGet(url);
    	// Get the response
    	ResponseHandler<String> responseHandler = new BasicResponseHandler();
    	try {
    		response_str = client.execute(request, responseHandler);
    	} catch (ClientProtocolException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return response_str;
    }
}