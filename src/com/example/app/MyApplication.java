package com.example.app;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static ArrayList<Activity> atys;
	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		MainVolley.init(this);
		mContext = getApplicationContext();
		atys = new ArrayList<Activity>();
	}

	public static Context getContext() {
		return mContext;
	}

	/**
	 * 关闭所有活动
	 */
	public static void finishAll() {
		for (Activity aty : atys) {
			if (!aty.isFinishing()) {
				aty.finish();
			}
		}
	}

	public static void addActivity(Activity aty) {
		if (!atys.contains(aty)) {
			atys.add(aty);
		}
	}

	public static void removeActivity(Activity aty) {
		if (atys.contains(aty)) {
			atys.remove(aty);
		}
	}
}
