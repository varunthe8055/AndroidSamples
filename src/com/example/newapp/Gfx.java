package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;

public class Gfx extends Activity {

	ItsGraphics IG;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		IG = new ItsGraphics(this);
		setContentView(IG);
		
	}
	

}
