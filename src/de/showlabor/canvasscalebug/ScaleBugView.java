/*
 * 
 * @author Felix Homann (linuxaudio@showlabor.de)
 * 
 * I don't think this file contains any copyrightable code.
 * So regard it as public domain code.
 * 
 */

package de.showlabor.canvasscalebug;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class ScaleBugView extends View{
	private final Paint paint = new Paint();
	private float x0 = 0.0f, y0 = 0.0f;
	private final Path circle = new Path();
	
	public ScaleBugView(Context context) {
		super(context);
		init();
	}

	public ScaleBugView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ScaleBugView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL);
		
		circle.addCircle(0f, 0f, 1.f, Path.Direction.CCW);		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		int diameter = Math.min(width, height);
		setMeasuredDimension(diameter, diameter);		
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		x0 = w/2.0f;
		y0 = h/2.0f;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.translate(x0, y0);
		canvas.scale(x0, y0);
		canvas.drawPath(circle, paint);
	}
}
