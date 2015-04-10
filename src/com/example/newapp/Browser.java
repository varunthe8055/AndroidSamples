package com.example.newapp;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends Activity implements OnClickListener{

	WebView wvpage;
	EditText url;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
//		wvpage.getSettings().setJavaScriptEnabled(true);
//		wvpage.getSettings().setLoadWithOverviewMode(true);
//		wvpage.getSettings().setUseWideViewPort(true);
		wvpage = (WebView)findViewById(R.id.webpa);
		wvpage.setWebViewClient(new webclient());
		wvpage.loadUrl("https://www.google.com");
		
		url = (EditText) findViewById(R.id.searchurl);
		Button bgogo = (Button) findViewById(R.id.go1);
		Button bgoback = (Button) findViewById(R.id.gobac);
		Button bgoforward = (Button) findViewById(R.id.gofron);
		Button bgoreload = (Button) findViewById(R.id.refres);
		Button bhist = (Button) findViewById(R.id.histo);
		
		bgogo.setOnClickListener(this);
		bgoback.setOnClickListener(this);
		bgoforward.setOnClickListener(this);
		bgoreload.setOnClickListener(this);
		bhist.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.go1:
			String web = url.getText().toString();
			wvpage.loadUrl(web);
			
//			hide the keyboard
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			
			break;
		case R.id.gobac:
			if (wvpage.canGoBack()) {
				wvpage.goBack();
			}
			
			break;
	case R.id.gofron:
		if (wvpage.canGoForward()) {
			wvpage.goForward();
		}
	
	break;
	case R.id.refres:
	wvpage.reload();
	break;
	
	case R.id.histo:
		wvpage.clearHistory();
	
	break;

		default:
			break;
		}
		
	}
	

}
