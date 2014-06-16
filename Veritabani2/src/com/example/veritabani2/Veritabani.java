package com.example.veritabani2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper {
	
	private static final String VERİTABANI_ADI = "isciler";
	private static final int SURUM = 1;
	
	public Veritabani(Context c) {
		super(c, VERİTABANI_ADI, null, SURUM);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE iscibilgi (ad TEXT, soyad TEXT, yas INTEGER, sehir TEXT);" );
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST iscibilgi");
		onCreate(db);
	}
	
	

}
