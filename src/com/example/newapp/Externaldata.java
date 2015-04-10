package com.example.newapp;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Externaldata extends Activity implements OnItemSelectedListener,OnClickListener {
	TextView ready;
	TextView writy;
	String str;
	Spinner spinn;
	boolean canr , canw;
	String [] arra = {"music","pic","downl"};
	File f = null;
	Button btnsavefi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		 ready = (TextView) findViewById(R.id.tvread);
		 writy = (TextView) findViewById(R.id.tvwrite);
		  spinn = (Spinner) findViewById(R.id.spinner1);
		 str = Environment.getExternalStorageState();
		 Button btnconfir = (Button)findViewById(R.id.confirm);
		 btnsavefi = (Button)findViewById(R.id.savefi);
		 EditText edifi = (EditText) findViewById(R.id.etsave);
		 TextView tvsaveas = (TextView) findViewById(R.id.saveas__);
		 btnconfir.setOnClickListener(this);
		 btnsavefi.setOnClickListener(this);
		 
		  
		 
		 if (str.equals(Environment.MEDIA_MOUNTED)) {
			 ready.setText("true");
			 writy.setText("true");
			canr = canw = true;
		} else if (str.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			 ready.setText("true");
			 writy.setText("false");
			 canr =  true;
			 canw = false;
		}else {
			 ready.setText("true");
			 writy.setText("false");
			 canr = canw = false;}
		 ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arra);
		 spinn.setAdapter(adap);
		 spinn.setOnItemSelectedListener(this);
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.confirm:
			btnsavefi.setVisibility(View.VISIBLE);
			break;

case R.id.savefi:
			
			break;
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
int place = spinn.getSelectedItemPosition();
		
		switch (place) {
		case 0:
			f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;

		case 1:
			 f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		case 2:
	 f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	   

}
