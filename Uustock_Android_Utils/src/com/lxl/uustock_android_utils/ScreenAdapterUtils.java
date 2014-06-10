package com.lxl.uustock_android_utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class ScreenAdapterUtils {

	static int width = 1080;
	static int height = 1920;
	static int smartBarHeight = 48;

	/**
	 * 设置原始屏幕尺寸。
	 * 
	 * @param w
	 * @param h
	 */
	public static void originalScreenWidthOrHeight(int w, int h) {
		width = w;
		height = h;
	}

	/**
	 * 适配当前屏幕的view。
	 * 
	 * @param view
	 *            从新计算高度的目标view。
	 * @param statusBar
	 *            是否把手机的状态栏的高度加入到换算的高度上(如全屏的时候是true，非全屏是false).
	 * @param smartBar
	 *            屏幕底部是否有虚拟键(有true，没有false).
	 */
	public static void adapterViews(View view, boolean statusBar,
			boolean smartBar) {
		int widthPixels = view.getContext().getResources().getDisplayMetrics().widthPixels;
		int heightPixels = view.getContext().getResources().getDisplayMetrics().heightPixels;
		if (!statusBar) {
			Rect frame = new Rect();
			Activity activity = (Activity) view.getContext();
			activity.getWindow().getDecorView()
					.getWindowVisibleDisplayFrame(frame);
			int statusBarHeight = frame.top;
			heightPixels = heightPixels - statusBarHeight;
		}

		if (smartBar) {
			int sbh = DpUtil.dip2px(view.getContext(), smartBarHeight);
			heightPixels = heightPixels - sbh;
		}

		if (view instanceof ViewGroup) {
			if (view instanceof LinearLayout) {
				int size = ((ViewGroup) view).getChildCount();
				for (int i = 0; i < size; i++) {
					View childView = ((ViewGroup) view).getChildAt(i);
					adapterLinearLayoutView(childView, widthPixels,
							heightPixels);
					adapterViews(childView, statusBar, smartBar);
				}
			}

			if (view instanceof RelativeLayout) {
				int size = ((ViewGroup) view).getChildCount();
				for (int i = 0; i < size; i++) {
					View childView = ((ViewGroup) view).getChildAt(i);
					adapterRelativeLayoutView(childView, widthPixels,
							heightPixels);
					adapterViews(childView, statusBar, smartBar);
				}
			}
			if (view instanceof TableLayout) {
				int size = ((ViewGroup) view).getChildCount();
				for (int i = 0; i < size; i++) {
					View childView = ((ViewGroup) view).getChildAt(i);
					adapterTableLayoutView(childView, widthPixels, heightPixels);
					adapterViews(childView, statusBar, smartBar);
				}
			}
			if (view instanceof FrameLayout) {
				int size = ((ViewGroup) view).getChildCount();
				for (int i = 0; i < size; i++) {
					View childView = ((ViewGroup) view).getChildAt(i);
					adapterFrameLayoutView(childView, widthPixels, heightPixels);
					adapterViews(childView, statusBar, smartBar);
				}
			}
		}
	}

	private static void adapterLinearLayoutView(View view, int w, int h) {
		LinearLayout.LayoutParams params = (LayoutParams) view
				.getLayoutParams();
		int paddingTop = scale(height, view.getPaddingTop(), h);
		int paddingLeft = scale(width, view.getPaddingLeft(), w);
		int paddingBottom = scale(height, view.getBottom(), h);
		int paddingRight = scale(width, view.getPaddingRight(), w);
		int morginTop = scale(height, params.topMargin, h);
		int morginLeft = scale(width, params.leftMargin, w);
		int morginBottom = scale(height, params.bottomMargin, h);
		int morginRight = scale(width, params.rightMargin, w);
		int width1 = scale(width, params.width, w);
		int height1 = scale(height, params.height, h);
		view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
		params.topMargin = morginTop;
		params.leftMargin = morginLeft;
		params.bottomMargin = morginBottom;
		params.rightMargin = morginRight;
		params.width = width1;
		params.height = height1;
		if (view instanceof TextView) {
			resetTextSize((TextView) view, w);
		} else if (view instanceof EditText) {
			resetEditSize((EditText) view, w);
		}
	}

	private static void adapterRelativeLayoutView(View view, int w, int h) {
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view
				.getLayoutParams();
		int paddingTop = scale(height, view.getPaddingTop(), h);
		int paddingLeft = scale(width, view.getPaddingLeft(), w);
		int paddingBottom = scale(height, view.getBottom(), h);
		int paddingRight = scale(width, view.getPaddingRight(), w);
		int morginTop = scale(height, params.topMargin, h);
		int morginLeft = scale(width, params.leftMargin, w);
		int morginBottom = scale(height, params.bottomMargin, h);
		int morginRight = scale(width, params.rightMargin, w);
		int width1 = scale(width, params.width, w);
		int height1 = scale(height, params.height, h);
		view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
		params.topMargin = morginTop;
		params.leftMargin = morginLeft;
		params.bottomMargin = morginBottom;
		params.rightMargin = morginRight;
		params.width = width1;
		params.height = height1;
		if (view instanceof TextView) {
			resetTextSize((TextView) view, w);
		} else if (view instanceof EditText) {
			resetEditSize((EditText) view, w);
		}
	}

	private static void adapterTableLayoutView(View view, int w, int h) {
		TableLayout.LayoutParams params = (TableLayout.LayoutParams) view
				.getLayoutParams();
		int paddingTop = scale(height, view.getPaddingTop(), h);
		int paddingLeft = scale(width, view.getPaddingLeft(), w);
		int paddingBottom = scale(height, view.getBottom(), h);
		int paddingRight = scale(width, view.getPaddingRight(), w);
		int morginTop = scale(height, params.topMargin, h);
		int morginLeft = scale(width, params.leftMargin, w);
		int morginBottom = scale(height, params.bottomMargin, h);
		int morginRight = scale(width, params.rightMargin, w);
		int width1 = scale(width, params.width, w);
		int height1 = scale(height, params.height, h);
		view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
		params.topMargin = morginTop;
		params.leftMargin = morginLeft;
		params.bottomMargin = morginBottom;
		params.rightMargin = morginRight;
		params.width = width1;
		params.height = height1;
		if (view instanceof TextView) {
			resetTextSize((TextView) view, w);
		} else if (view instanceof EditText) {
			resetEditSize((EditText) view, w);
		}
	}

	private static void adapterFrameLayoutView(View view, int w, int h) {
		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view
				.getLayoutParams();
		int paddingTop = scale(height, view.getPaddingTop(), h);
		int paddingLeft = scale(width, view.getPaddingLeft(), w);
		int paddingBottom = scale(height, view.getBottom(), h);
		int paddingRight = scale(width, view.getPaddingRight(), w);
		int morginTop = scale(height, params.topMargin, h);
		int morginLeft = scale(width, params.leftMargin, w);
		int morginBottom = scale(height, params.bottomMargin, h);
		int morginRight = scale(width, params.rightMargin, w);
		int width1 = scale(width, params.width, w);
		int height1 = scale(height, params.height, h);
		view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
		params.topMargin = morginTop;
		params.leftMargin = morginLeft;
		params.bottomMargin = morginBottom;
		params.rightMargin = morginRight;
		params.width = width1;
		params.height = height1;
		if (view instanceof TextView) {
			resetTextSize((TextView) view, w);
		} else if (view instanceof EditText) {
			resetEditSize((EditText) view, w);
		}
	}

	/**
	 * 换算比例。
	 * 
	 * @param originalScreen
	 *            原始屏幕的高或宽。
	 * @param originalView
	 *            原始view的高或宽。
	 * @param currentScreen
	 *            当前屏幕的高或宽。
	 * @return 当前view的高或宽。
	 */
	private static int scale(int originalScreen, int originalView,
			int currentScreen) {
		if (originalView > 0) {
			float scale = originalView / Float.valueOf(originalScreen);
			int currentView = (int) (scale * currentScreen);
			return currentView;
		} else {
			return originalView;
		}
	}

	/**
	 * 将 TextView（或其子类）文本大小按比例设置；
	 * 
	 * @param scale
	 *            缩放比例；
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@SuppressLint("NewApi")
	private static void resetTextSize(TextView textView, int w) {
		float size = textView.getTextSize();
		textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
				scale(width, (int) size, w));
		float spacingExtra = 0;
		float spacingMultip = 1;
		try {
			spacingExtra = textView.getLineSpacingExtra();
			spacingMultip = textView.getLineSpacingMultiplier();
		} catch (NoSuchMethodError e) {

		}
		textView.setLineSpacing(scale(width, (int) spacingExtra, w),
				spacingMultip);
	}

	/**
	 * 将 TextView（或其子类）文本大小按比例设置；
	 * 
	 * @param scale
	 *            缩放比例；
	 */
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@SuppressLint("NewApi")
	private static void resetEditSize(EditText textView, int w) {
		float size = textView.getTextSize();
		textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
				scale(width, (int) size, w));
		float spacingExtra = 0;
		float spacingMultip = 1;
		try {
			spacingExtra = textView.getLineSpacingExtra();
			spacingMultip = textView.getLineSpacingMultiplier();
		} catch (NoSuchMethodError e) {

		}
		textView.setLineSpacing(scale(width, (int) spacingExtra, w),
				spacingMultip);
	}

}
