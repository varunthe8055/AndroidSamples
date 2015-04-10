package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Sqlview extends Activity {
	TextView tvhotness, tvnames, tvsqldata;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tvhotness = (TextView)findViewById(R.id.Hotness);
		TextView tvnames = (TextView)findViewById(R.id.Hotnames);
				TextView tvsqldata = (TextView)findViewById(R.id.sqldata);
				Hotornot dta = new Hotornot(this);
				dta.ope();
			String info =	dta.getdata();
				dta.close();
				tvsqldata.setText(info);
	}
	

}
