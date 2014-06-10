package com.lxl.uustock_android_utils;

import android.util.Base64;

/**
 * Base64数据处理
 * 
 * @author angleline
 * 
 */
public class Base64Util {
	private static final int BASE64_FLAG = Base64.DEFAULT;

	/**
	 * Base64加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		return Base64.encodeToString(str.getBytes(), BASE64_FLAG);
	}

	/**
	 * Base64解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decode(String str) {
		return new String(Base64.decode(str, BASE64_FLAG));
	}
}
