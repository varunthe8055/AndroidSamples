package com.example.newapp;



import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Whatev extends PreferenceActivity{

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.what);
	}

}
