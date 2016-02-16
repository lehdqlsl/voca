package com.example.slidingsimplesample;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Setting {

	// private String user_id;
	private String name;
	private String interval;

	public static final String VOCA_SETTING_INFO = "VOCA_SETTING_INFO";

	/**
	 * ����ȭ�� �ٷΰ���
	 * 
	 * @param context
	 * @param FIRST_DIALOG
	 */
	public static final String PREF_KEY_INTERVAL00 = "1500";

	public static void setINTERVAL(Context context, boolean FIRST_DIALOG) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_INTERVAL00, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean(VOCA_SETTING_INFO, FIRST_DIALOG);
		editor.commit();
	}

	public static boolean getINTERVAL(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_INTERVAL00, Activity.MODE_PRIVATE);
		return pref.getBoolean(VOCA_SETTING_INFO, false);
	}

	public static final String PREF_KEY_INTERVAL = "1500";

	public static void setinterval(Context context, String interval) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_INTERVAL, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString(VOCA_SETTING_INFO, interval);
		editor.commit();
	}

	public static String getinterval(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_INTERVAL, Activity.MODE_PRIVATE);
		return pref.getString(VOCA_SETTING_INFO, "");
	}

	public static final String PREF_KEY_CONCEAL = "YES";

	public static void setconceal(Context context, String interval) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_CONCEAL, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString(VOCA_SETTING_INFO, interval);
		editor.commit();
	}

	public static String getconceal(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_CONCEAL, Activity.MODE_PRIVATE);
		return pref.getString(VOCA_SETTING_INFO, "");
	}

	public static final String PREF_KEY_name = "name";

	public static void setname(Context context, String name) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_name, Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString(VOCA_SETTING_INFO, name);
		editor.commit();
	}

	public static String getname(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY_name, Activity.MODE_PRIVATE);
		return pref.getString(VOCA_SETTING_INFO, "");
	}

	public String getINTERVAL() {
		return interval;
	}

	public void setINTERVAL(String interval) {
		this.interval = interval;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
