package com.example.newapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class fileoutput  extends Activity implements OnClickListener{
	EditText fileedi;
	TextView tvloadfile;
	String filename = "myfileout";
	FileOutputStream fos;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.sharedpref);
	fileedi = (EditText)findViewById(R.id.EditShare);
	Button bsavefile = (Button)findViewById(R.id.SaveShared);
	Button bloadfile = (Button)findViewById(R.id.LoadShared);
	tvloadfile = (TextView)findViewById(R.id.textShared);
	bsavefile.setOnClickListener(this);
	bloadfile.setOnClickListener(this);
	try {
		fos = openFileOutput(filename, Context.MODE_PRIVATE);
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.SaveShared:
			String strdtata = fileedi.getText().toString();
			File f = new File(filename);
			try {
				fos = new FileOutputStream(f);
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos = openFileOutput(filename, Context.MODE_PRIVATE);
				try {
					fos.write(strdtata.getBytes());
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;
		case R.id.LoadShared:
			
			break;

		default:
			break;
		}
		
	}

}
