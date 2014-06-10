package com.lxl.uustock_android_utils;

/*************************************************************************************************************
 * 
 * 							说明：
 * 我们说到的和手机、卡相关的号码数据包括IMSI,MSISDN,ICCID，
 * IMEIIMSI：international mobiles subscriber identity国际移动用户号码标识，这个一般大家是不知道，GSM必须写在卡内相关文件中；
 * MSISDN:mobile subscriber ISDN用户号码，这个是我们说的139，136那个号码；
 * ICCID:ICC identity集成电路卡标识，这个是唯一标识一张卡片物理号码的；
 * IMEI：international mobile Equipment identity手机唯一标识码；
 * 
 * ***********************************************************************************************************/

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

public class PhoneInfoUtils {

	Context context;
	TelephonyManager tm;

	public PhoneInfoUtils(Context context) {
		this.context = context;
		tm = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
	}

	/** 取出IMEI */
	public String getIMEI() {
		return tm.getDeviceId();
	}

	/** 手机型号 */
	public String getModel() {
		return Build.MODEL;
	}

	/** SDK版本号 */
	public String getSDK() {
		return Build.VERSION.SDK;
	}

	/** 取出(手机号)MSISDN，很可能为空 */
	public String getPhoneNumber() {
		return tm.getLine1Number();
	}

	/** 取出ICCID */
	public String getICCID() {
		return tm.getSimSerialNumber();
	}

	/** 取出ICCID */
	public String getIMSI() {
		return tm.getSubscriberId();
	}

	/** 获得自己程序的版本号 */
	public String getAppVersionName() {

		String versionName = "";

		try {

			// ---get the package info---

			PackageManager pm = context.getPackageManager();

			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);

			versionName = pi.versionName;

			if (versionName == null || versionName.length() <= 0) {

				return "";
			}

		} catch (Exception e) {

			// Log.e(TAG, "Exception", e);

		}
		return versionName;

	}

}
