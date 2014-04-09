package com.example.veritabani;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper{

	private static final String VERITABANI_ADI = "kayitlar";
	private static final int SURUM = 1; 
	
	public Veritabani( Context c) {
		super(c, VERITABANI_ADI	, null, SURUM);
			}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE bilgiler (ad TEXT, soyad TEXT);" );
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST bilgiler");
		onCreate(db);		
	}
	

}
