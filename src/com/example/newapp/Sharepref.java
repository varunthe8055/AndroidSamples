package com.example.newapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sharepref extends Activity implements OnClickListener{
	
	EditText edi;
	TextView tvload;
	SharedPreferences shd;
	String filename = "myfile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpref);
		edi = (EditText)findViewById(R.id.EditShare);
		Button bsave = (Button)findViewById(R.id.SaveShared);
		Button bload = (Button)findViewById(R.id.LoadShared);
		tvload = (TextView)findViewById(R.id.textShared);
		bsave.setOnClickListener(this);
		bload.setOnClickListener(this);
		shd = getSharedPreferences(filename, 0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.SaveShared:
			String zt = edi.getText().toString();
			SharedPreferences.Editor edito = shd.edit();
			edito.putString("random", zt);
			edito.commit();
//			hide the keyboard
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(edi.getWindowToken(), 0);
			
			
			break;
		case R.id.LoadShared:
			shd = getSharedPreferences(filename, 0);
			String returnd = shd.getString("random", "not present");
			tvload.setText(returnd);
			
			break;

		default:
			break;
		}
		
	}
	

}
