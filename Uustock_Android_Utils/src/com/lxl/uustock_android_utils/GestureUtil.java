package com.lxl.uustock_android_utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/**
 * 对MotionEvent进行方向判断。
 * 
 * @author liuxiaolong
 * 
 */
public class GestureUtil implements OnGestureListener {
	private GestureDetector mGestureDetector;
	private GestureListener gestureListener;
	private int minMove = 100, velocity = 200;

	public GestureUtil(Context context, GestureListener gestureListener) {
		mGestureDetector = new GestureDetector(context, this);
		this.gestureListener = gestureListener;
	}

	/**
	 * 添加滑动最小距离和滑动速率。
	 * 
	 * @param move
	 * @param velo
	 */
	public void setMinMoveOrvelocity(int move, int velo) {
		minMove = move;
		velocity = velo;
	}

	/**
	 * 设置手势判定
	 * 
	 * @param mEvent坐标事件
	 *            .
	 * 
	 */
	public boolean setMotionEvent(MotionEvent mEvent) {
		return mGestureDetector.onTouchEvent(mEvent);
	}

	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		if (e1.getX() - e2.getX() > minMove && Math.abs(velocityX) > velocity) {
			gestureListener.gestureLeft(e1.getX() - e2.getX());
		} else if (e2.getX() - e1.getX() > minMove
				&& Math.abs(velocityX) > velocity) {
			gestureListener.gestureRight(e1.getX() - e2.getX());
		} else if (e2.getY() - e1.getY() > minMove
				&& Math.abs(velocityY) > velocity) {
			gestureListener.gestureDown(e1.getX() - e2.getX());
		} else if (e1.getY() - e2.getY() > minMove
				&& Math.abs(velocityY) > velocity) {
			gestureListener.gestureUp(e1.getX() - e2.getX());
		}
		return true;
	}

	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	public interface GestureListener {
		public void gestureLeft(Float distance);

		public void gestureRight(Float distance);

		public void gestureUp(Float distance);

		public void gestureDown(Float distance);
	}

}
