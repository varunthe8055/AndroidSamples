package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hotnessql extends Activity implements OnClickListener{

	Button btnupdate, btnhot;
	TextView tvhot, tvnamehot;
	EditText ethoty, etscaly;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hotnessql);
		
		btnupdate = (Button)findViewById(R.id.update);
		btnhot = (Button)findViewById(R.id.Viewhot);
		tvhot = (TextView)findViewById(R.id.Hotness);
		tvnamehot = (TextView)findViewById(R.id.namehot);
		 ethoty = (EditText)findViewById(R.id.ethot);
		 etscaly = (EditText)findViewById(R.id.etscale);
		
		btnupdate.setOnClickListener(this);
		btnhot.setOnClickListener(this);		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.update:
			boolean diditwork = true;
			try{
			String stname = ethoty.getText().toString();
			String stscale = etscaly.getText().toString();
			
			Hotornot entr = new Hotornot(this);
			entr.ope();
			entr.create(stname ,stscale );
			entr.close();}
			catch (Exception e) {
				// TODO: handle exception
				 diditwork = false;
			}
			
			break;

case R.id.Viewhot:
	Intent i = new Intent("com.example.newapp.SQLVIEW");
	startActivity(i);
			
			break;
		}
		
	}
	

}
