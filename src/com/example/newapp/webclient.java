package com.example.newapp;

import java.net.URL;

import android.R.string;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webclient extends WebViewClient {
	
	public boolean genramenthod (WebView v, String url){
		
		v.loadUrl(url);
		
		return true;
		
		
	}

}
