package com.example.newapp;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {
	TabHost thost;
	TextView Resu;
	long start, stop;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tabs);
		thost = (TabHost) findViewById(R.id.tabhost);
		Button btnstart = (Button)findViewById(R.id.startw);
    	Button btnstop = (Button)findViewById(R.id.stopw);
    	Button btnadd = (Button) findViewById(R.id.butonadd);
    	 Resu = (TextView) findViewById(R.id.textresults);
    	btnstart.setOnClickListener(this);
    	btnstop.setOnClickListener(this);
    	btnadd.setOnClickListener(this);
    	start = 0 ;
    	
		thost.setup();
		TabSpec tspec = thost.newTabSpec("tag1");
		tspec.setContent(R.id.tab1);
		tspec.setIndicator("stopwatch");
		thost.addTab(tspec);
		
		TabSpec tspec2 = thost.newTabSpec("tag2");
		tspec2.setContent(R.id.tab2);
		tspec2.setIndicator("taby");
		thost.addTab(tspec2);
		
		TabSpec tspec3 = thost.newTabSpec("Tag3");
		tspec3.setContent(R.id.tab3);
		tspec3.setIndicator("lasTab");
		thost.addTab(tspec3);
				
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.startw:
			start = System.currentTimeMillis();
			break;
			
        case R.id.stopw:
        	stop = System.currentTimeMillis();
        	if (start != 0 ) {
        		long resul = stop -start;
        		int milli = (int)resul;
        		int sec = milli/ 1000;
        		int min = sec/60;
        		milli = milli%100;
        		sec = sec%60;
        		
        		
        		Resu.setText(String.format("%d:%02d:%02d", min,sec,milli));
				
			}
			
			break;
        case R.id.butonadd:
        	TabSpec tspec4 = thost.newTabSpec("tag4");
//			tspec4.setContent(new TabHost.TabContentFactory() {
//				
//				@Override
//				public View createTabContent(String tag) {
//					// TODO Auto-generated method stub
//					TextView tw = new TextView (Tabs.this);
//					tw.setHint("Enter text");
//					return tw;
//				}
//			});
			
			tspec4.setContent(R.id.tab4);
			tspec4.setIndicator("addta");
			thost.addTab(tspec4);
	
        	break;

		default:
			break;
		}
		
	}

}
