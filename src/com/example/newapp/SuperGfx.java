package com.example.newapp;

import android.app.Activity;
import android.app.usage.UsageEvents.Event;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class SuperGfx extends Activity implements OnTouchListener{
	SuperItsGraphics brin;
	
	float x  ;
	float y   ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		brin = new SuperItsGraphics (this);
		x = 0;
		y = 0;
		setContentView(brin);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x  = event.getX();
		y = event.getY();
		return false;
	}
	public class SuperItsGraphics extends SurfaceView implements Runnable{
		
		SurfaceHolder hold;
	     Thread tr;
	    boolean isrunning = true;
		public SuperItsGraphics(Context context) {
			super(context);
			hold = getHolder();
			tr = new Thread(this);
			tr.start();
			
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isrunning) {
				if (!hold.getSurface().isValid()) {
					continue;
				}Canvas can = hold.lockCanvas();
				can.drawRGB(10, 15, 20);
//				if (x !=0 && y !=0){
				Bitmap BT = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
				can.drawBitmap(BT, x, y, null);
				
				hold.unlockCanvasAndPost(can);
				
			}
			
			
		}
	}

}
