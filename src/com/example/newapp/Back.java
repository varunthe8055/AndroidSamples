package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Back extends Activity{
	
	MediaPlayer song;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bakgrnd);
		
	 song = MediaPlayer.create(Back.this, R.raw.sampsong);
	 SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(this);
	 Boolean music = sh.getBoolean("chck", true);
	 if(music == true){
		song.start();
		}
		Thread t = new Thread() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
				sleep(10000);
				} catch (Exception e) {
					// TODO: handle exception
					
				}finally {
					Intent i = new Intent("com.example.newapp.MENU");
					startActivity(i);
				}
				
			}
		};
		t.start();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
}
		
	
	
	


