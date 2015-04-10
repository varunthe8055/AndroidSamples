package com.example.newapp;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Email extends Activity implements View.OnClickListener{
	
	TextView emal , first , multi, subby ;
	String e, n , m , s;
	Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initialize();
		btn.setOnClickListener(this);	
	}
	
	public void initialize() {
		 emal = (TextView)findViewById(R.id.eml);
		 first = (TextView)findViewById(R.id.name);
		 subby = (TextView)findViewById(R.id.sub);
		 multi = (TextView)findViewById(R.id.mtr);
		 btn = (Button)findViewById(R.id.send);	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		meat();
		String ema []= {e};
		String mes = "Hello" + n +"I am mailing you because"+ s+ m;
		
		Intent i = new Intent(android.content.Intent.ACTION_SEND);
		i.putExtra(android.content.Intent.EXTRA_EMAIL,ema );
		i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Mail");
		i.putExtra(android.content.Intent.EXTRA_TEXT, mes);
		startActivity(i);
		
		
		
	}
	public void meat() {
		String e = emal.getText().toString();
		String n = first.getText().toString();
		String m = multi.getText().toString();
		String s  = subby.getText().toString();
	
	}
	
	@Override
	public void onPause() {
		super.onPause();
		finish();
		
	}
	
	
	
	
	
	

}
