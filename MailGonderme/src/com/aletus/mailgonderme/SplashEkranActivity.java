package com.aletus.mailgonderme;


import com.aletus.mailgonderme.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashEkranActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash1);    
    Thread iplik = new Thread()
    { 
    	public void run() {
      		
    		try {
				sleep(4000);
				startActivity(new Intent("android.intent.action.MAILGONDERME"));
    		} catch (InterruptedException e) {
				e.printStackTrace();
			}	
    		finally{
    			finish();
    		}		
		}
    };
    
	 iplik.start();   
    
    } 
}