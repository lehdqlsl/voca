package com.example.slidingsimplesample;

import java.io.File;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class Download_fm extends Fragment {


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_download_fm, container, false);
		Button btn_google_drive = (Button) v.findViewById(R.id.btn_google_drive);
		Button btn_N_drive = (Button) v.findViewById(R.id.btn_n_drive);


		btn_google_drive.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = getActivity().getPackageManager()
						.getLaunchIntentForPackage("com.google.android.apps.docs");

				if (intent != null) {
					startActivity(intent);
					Toast.makeText(getActivity(), "구글 드라이버를 실행합니다.", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getActivity(), "구글 드라이버가 설치되어 있지 않습니다.", Toast.LENGTH_SHORT).show();
				}

			}
		});

		btn_N_drive.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.nhn.android.ndrive");
				if (intent != null) {
					startActivity(intent);
					Toast.makeText(getActivity(), "네이버 클라우드를 실행합니다.", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getActivity(), "네이버 클라우드가 설치되어 있지 않습니다.", Toast.LENGTH_SHORT).show();
				}
			}
		});

		return v;
	}

}