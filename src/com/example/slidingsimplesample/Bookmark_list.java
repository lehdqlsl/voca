package com.example.slidingsimplesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Bookmark_list extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bookmark_list);
	}

}
