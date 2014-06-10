package com.lxl.uustock_android_utils;

import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class AppUtil {

	/**
	 * 判断系统是否安装此程序。
	 * 
	 * @return
	 */
	public static boolean traverseAppName(String appName, Context context) {
		boolean has = false;
		PackageManager pageManage = context.getPackageManager();
		List<PackageInfo> packages = pageManage.getInstalledPackages(0);
		for (int i = 0; i < packages.size(); i++) {
			PackageInfo packageInfo = packages.get(i);
			String pagName = packageInfo.packageName;
			if (pagName.equals(appName)) {
				has = true;
			}
		}
		return has;
	}

	/**
	 * 跳转到其他应用程序。
	 * 
	 * @param packageName
	 * @param context
	 * @throws NameNotFoundException
	 */
	public static void openApp(String packageName, Context context)
			throws NameNotFoundException {
		PackageManager packageManager = context.getPackageManager();
		PackageInfo pi = context.getPackageManager().getPackageInfo(
				packageName, 0);
		Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
		resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		resolveIntent.setPackage(pi.packageName);
		List<ResolveInfo> apps = packageManager.queryIntentActivities(
				resolveIntent, 0);
		ResolveInfo ri = apps.iterator().next();
		if (ri != null) {
			String packagen = ri.activityInfo.packageName;
			String className = ri.activityInfo.name;
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			ComponentName cn = new ComponentName(packagen, className);
			intent.setComponent(cn);
			context.startActivity(intent);
		}
	}
}
