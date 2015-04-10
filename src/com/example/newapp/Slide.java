package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slide extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	SlidingDrawer SD;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		Button bn1 = (Button) findViewById(R.id.Btn1);
		Button bn2 = (Button) findViewById(R.id.Btn2);
		Button bn3 = (Button) findViewById(R.id.btn3);
		CheckBox Chbox = (CheckBox) findViewById(R.id.cBox);
		Chbox.setOnCheckedChangeListener(this);
		 SD = (SlidingDrawer) findViewById(R.id.slidingDrawer);
		SD.setOnDrawerOpenListener((OnDrawerOpenListener) this);
		bn1.setOnClickListener(this);
		bn2.setOnClickListener(this);
		bn3.setOnClickListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (isChecked) {
			
			SD.lock();
			
		} else {
			SD.unlock();

		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.Btn1:
			SD.open();
			
			break;
        case R.id.Btn2:
			SD.toggle();
			break;
       case R.id.btn3:
    	   SD.close();
	
	break;

		default:
			break;
		}
		
		
	}
	
	

}
