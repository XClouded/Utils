package com.lxl.uustock_android_utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

public class SDUtil {

	/**
	 * 获取sd卡状态�?
	 * 
	 * @return true 可用，false 不可用�?
	 */
	public static boolean SDCardState() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取sd卡的路径�?
	 * 
	 * @return
	 */
	public static String SDCardPath() {
		if (SDCardState()) {
			String SDPATH = Environment.getExternalStorageDirectory().getPath();
			return SDPATH;
		} else {
			return null;
		}
	}

	/**
	 * 获取手机data路径。
	 * 
	 * @param context
	 * @return
	 */
	public static String DadaPath(Context context) {
		return context.getFilesDir().getPath();
	}

	/**
	 * 获取sd卡剩余空�?
	 * 
	 * @return （以MB为单位）
	 */
	public static long SDCardFree() {
		if (null != SDCardPath() && !SDCardPath().equals("")) {
			StatFs statfs = new StatFs(SDCardPath());
			long availaBlocks = statfs.getAvailableBlocks();
			long blockSize = statfs.getBlockSize();
			long SDFreeSize = availaBlocks * blockSize / 1024 / 1024;
			return SDFreeSize;
		} else {
			return 0;
		}
	}

}
