package com.example.newapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyMenu extends ListActivity {
	
	String acti [] = {"MainActivity","texty","SuperGfx","Gfx","Email",
			"Slide","Tabs", "Browser", "Flipper","Sharepref","fileoutput","Externaldata", "Hotnessql"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(MyMenu.this, android.R.layout.simple_list_item_1,acti));
	}
	


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Class samcls;
		try {
			String s = acti [position];
			samcls = Class.forName("com.example.newapp."+ s);
			Intent i = new Intent(MyMenu.this,samcls);
			startActivity(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater blow = getMenuInflater();
		 blow.inflate(R.menu.smenu, menu);
	 return true ;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.abt:
			Intent i = new Intent("com.example.newapp.ABOU");
			startActivity(i);
			
			break;
        case R.id.wbt:
			Intent p = new Intent("com.example.newapp.WHATEV");
			startActivity(p);
			break;
        case R.id.exit:
			finish();
			break;
		default:
			break;
		}
		return false;
	}
	
   
	
	

}
