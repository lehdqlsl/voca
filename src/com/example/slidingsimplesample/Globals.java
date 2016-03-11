package com.example.slidingsimplesample;

import java.util.List;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class Globals extends Application {
	private static List<String> adapter;

	public void adpaterInit() {
		if (adapter.isEmpty()) {
			adapter.add("토플");
			adapter.add("Test1");
			adapter.add("Test2");
		} else {
			// 비어있지 않으면 리스트 불러옴
		}
	}

	public List<String> getAdapter() {
		return adapter;
	}

	public void setList(List<String> list) {
		Globals.adapter = list;
	}

	public void AddList(String str) {
		adapter.add(str);
	}

	public void print() {
		for (int i = 0; i < adapter.size(); i++) {
			Log.i("INFO", adapter.get(i));
		}
	}

}
