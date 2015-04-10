package com.example.newapp;

import java.util.Random;

import android.R.color;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class texty extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		Button b = (Button)findViewById(R.id.btn);
		final ToggleButton tbn = (ToggleButton) findViewById(R.id.toggleButton1);
		final TextView  tv= (TextView)findViewById(R.id.textView1);
		final EditText etv = (EditText)findViewById(R.id.editText1);
		
		tbn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tbn.isChecked()) {
					etv.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
				} else {
                      etv.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
		b.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String chese = etv.getText().toString();
				
				if (chese.contentEquals("left")) {
					tv.setGravity(Gravity.LEFT);
					
				} else if (chese.contentEquals("center")){
					tv.setGravity(Gravity.CENTER);

				}else if  (chese.contentEquals("right")){
					tv.setGravity(Gravity.RIGHT);
				}else if (chese.contentEquals("blue")) {
					tv.setTextColor(color.holo_blue_dark);
					
				}else if (chese.contentEquals("wt")) {
					Random r = new Random();
					switch (r.nextInt(3)){
					case 0 :
						tv.setGravity(Gravity.LEFT);
						break;
					case 1 :
						tv.setGravity(Gravity.CENTER);
						break;
					case 2 :
						tv.setGravity(Gravity.RIGHT);
						break;
					
					}
				}else{
					tv.setTextColor(color.darker_gray);
				}
				
			}
		});
		
		
	}
	
	

}
