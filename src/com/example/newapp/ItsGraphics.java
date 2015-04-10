package com.example.newapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class ItsGraphics extends View {

	Bitmap green;
	int changing;
	public ItsGraphics(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		green = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(green, canvas.getWidth()/2, changing, null);
	if(changing<canvas.getHeight()){
		changing=+10;
	}else {
		changing = 0;	
	}
	invalidate();
	Rect middle = new Rect();
	middle.set(0, 400, canvas.getWidth(), 550);
    Paint clr = new Paint();
    clr.setColor(Color.YELLOW);
    canvas.drawRect(middle, clr);
	
	
	}

}
