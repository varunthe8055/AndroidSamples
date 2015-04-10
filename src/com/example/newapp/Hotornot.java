package com.example.newapp;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Hotornot {
	
	public static final String Key_Id = "_id" ;
	public static final String Key_name = "_name";
	public static final String Key_hot = "_hot";
	
	private static final String DB_table = "people_table";
	private static final String DB_name = "tablename_hotornot";
	private static final int DB_version = 1;
	
	//create instance of subclass
	private sqlclassopen sqlclass;
	//
	private final Context ourcontext;
	private SQLiteDatabase ourdb;
	
	
	public class sqlclassopen extends SQLiteOpenHelper{

		public sqlclassopen(Context context) {
			super(context,DB_name,null,DB_version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
			db.execSQL("CREATE TABLE "+ DB_table + "(" + Key_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ Key_name + "TEXT NOT NULL, " + Key_hot + " TEXT NOT NULL);"
					);		
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS" + DB_table);
			onCreate(db);
			
		}
}
	public Hotornot(Context C){
		ourcontext = C;
	}
	
	public Hotornot ope(){
		sqlclass = new sqlclassopen(ourcontext);
		ourdb = sqlclass.getWritableDatabase();
		return this;
		}
	public void close(){
		sqlclass.close();
		
	}

	public long create(String stname, String stscale) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(Key_name, stname);
		cv.put(Key_hot, stscale);
		return ourdb.insert(DB_table, null, cv);
		
	}

	public String getdata() {
		// TODO Auto-generated method stub
		String [] clmns = {"Key_Id", "Key_name","Key_hot"};
		Cursor c = ourdb.query(DB_table, clmns, null, null, null, null, null, null);
		String result = "";
		
		int irow = c.getColumnIndex(Key_Id);
		int iname = c.getColumnIndex(Key_name);
		int ihot = c.getColumnIndex(Key_hot);
		for (c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			result = result + c.getString(irow)+ " " + c.getString(iname)+ " " + c.getString(ihot) +"\n";
		}
		
		
		
		return result;
	}
}