package com.example.newapp;


import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {
	
	ImageButton imgbtn;
	ImageView imgv;
	Button b;
	int camdata = 0;
	Bitmap bmp;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cam);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.backgrnd);
	     bmp = BitmapFactory.decodeStream(is);
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
	imgbtn = (ImageButton)findViewById(R.id.picbtn);
	imgv = (ImageView)findViewById(R.id.pic);
	b = (Button)findViewById(R.id.Takepic);
	b.setOnClickListener(this);
	imgbtn.setOnClickListener(this);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (b.getId()) {
		case R.id.Takepic: 
			Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, camdata);
			break;
        case R.id.picbtn:
        	try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		default:
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle ex = data.getExtras();
			 bmp = (Bitmap) ex.get("data");
			imgv.setImageBitmap(bmp);
		}
	}
	

}
