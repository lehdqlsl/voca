package com.example.slidingsimplesample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.AssetManager.AssetInputStream;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.Directory;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ModelListViewActivity extends ListActivity {

	private static final String TAG_VOCA = "VOCA";
	private static final String TAG_SCRIPT = "SCRIPT";
	private static int count = 0;
	private static int countSecond = 0;
	private static int reverse = 1;
	private static int loopCount = 0;

	private ArrayList<String> mChildList001 = null;
	private ArrayList<String> mChildList002 = null;

	List<Model> list;
	ArrayAdapter<Model> adapter;

	List<ModelSecond> listSecond;
	ArrayAdapter<ModelSecond> adapterSecond;

	TextView vocabulary;
	TextView script;

	Button btnApple001, btnApple002, btnApple003;

	String dayName;
	String fileName = "";
	String jsonName;

	public static final String TAG = "TestFileActivity";
	static File Path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	public static final String STRSAVEPATH = Path.getPath();
	public static final String STRSAVEPATH2 = Environment.getExternalStorageDirectory() + "/testfolder2/";
	public static String SAVEFILEPATH = "MyFile.txt";
	FileOutputStream fout;

	File dir;
	File file;
	String tempName;

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.list_main);

		Log.i("INFO", "경로" + Environment.getExternalStorageDirectory());

		Intent intent = getIntent();
		dayName = intent.getExtras().get("name").toString();
		String tempTitle = dayName + " Day";
		setTitle(tempTitle);

		SAVEFILEPATH = "toefl" + dayName + ".txt";
		tempName = STRSAVEPATH + SAVEFILEPATH;
		Log.i("test", "test: " + tempName);

		btnApple001 = (Button) findViewById(R.id.review1);
		btnApple002 = (Button) findViewById(R.id.review2);
		btnApple003 = (Button) findViewById(R.id.review3);

		vocabulary = (TextView) findViewById(R.id.vocaburary);
		script = (TextView) findViewById(R.id.script);

		btnApple002.setVisibility(View.GONE);
		btnApple003.setVisibility(View.GONE);
		vocabulary.setVisibility(View.GONE);
		script.setVisibility(View.GONE);

		btnApple001.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {

				// secFuncion2();
				secFunction();
				adapter.clear();
				btnApple001.setVisibility(View.GONE);
				btnApple002.setVisibility(View.VISIBLE);
				String changTitle = "Remember (" + countSecond + ")";
				btnApple002.setText(changTitle);

			}
		});

		btnApple002.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				btnApple002.setVisibility(View.GONE);
				btnApple003.setVisibility(View.VISIBLE);

				loopCount = 0;

				rememberFunction();

			}
		});

		btnApple003.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {

				loopCount++;

				Log.i("test", "1reverse: " + reverse);
				if (reverse == 1)
					reverse = 100;
				else if (reverse == 100)
					reverse = 1;

				Log.i("test", "2reverse: " + reverse + ",loopCount: " + loopCount);

				myThreadCall();

			}
		});

		if (dayName.equals("all")) {

			adapter = new MyCustomArrayAdapter(this, getExcel(intent));
			setListAdapter(adapter);

			for (int i = 0; i < list.size(); i++) {
				Log.i("INFO", "data ; " + list.get(i).getName());
			}

		} else {

			jsonName = "toefl" + dayName + ".json";

			countSecond = 0;

			Log.i("OnCreate", "Main: " + jsonName);

			adapter = new MyCustomArrayAdapter(this, getModel());
			setListAdapter(adapter);

			// list.get(0).setSelected(true);

		}

	}

	/* Creates the menu items */
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "ALL Check");
		menu.add(0, 2, 0, "ALL Unckeck");
		return true;
	}

	public void newGame() {
		// list.setClickable(false);
		// list.setFocusable(false);
		list.get(0).setSelected(true);

	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			// newGame();
			// Log.i("onOptionsItemSelected","item.getItemId() " + 1);
			for (int i = 0; i < count; i++) {
				list.get(i).setSelected(true);
				// Log.i("onOptionsItemSelected","item.getItemId: " + i);
			}
			setListAdapter(adapter);

			break;
		case 2:
			// quit();
			// Log.i("onOptionsItemSelected","item.getItemId() " + 1);
			for (int i = 0; i < count; i++) {
				list.get(i).setSelected(false);
				// Log.i("onOptionsItemSelected","item.getItemId: " + i);
			}
			setListAdapter(adapter);

			break;
		}
		return true;
	}

	private void rememberFunction() {

		adapterSecond.clear();

		vocabulary.setVisibility(View.VISIBLE);
		script.setVisibility(View.VISIBLE);

		// ���� ����
		dir = makeDirectory(STRSAVEPATH);
		// ���� ����
		file = makeFile(dir, (STRSAVEPATH + SAVEFILEPATH));

		tempName = STRSAVEPATH + SAVEFILEPATH;

		File savefile = new File(tempName);

		try {
			FileOutputStream fos = new FileOutputStream(savefile);

			for (int i = 0; i < mChildList001.size(); i++) {
				Log.i("array", "" + mChildList001.get(i));

				String TempString1 = mChildList001.get(i);
				String TempString2 = mChildList002.get(i);
				String TempString = TempString1 + "@" + TempString2;

				fos.write(TempString.getBytes());
				fos.write("\n".getBytes());

				// vocaburary.setText(mChildList001.get(i));
				// script.setText(mChildList002.get(i));
			}

			fos.close();
			Toast.makeText(this, "Save Success", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
		}

		reverse = 1;
		myThreadCall();

	}

	private void myThreadCall() {
		vocabulary.setText("Loading...");
		script.setText("");
		MyThread myThread = new MyThread();
		myThread.setDaemon(true);
		myThread.start();
	}

	private void secFuncion2() {

		adapterSecond = new MyCustomArrayAdapterSecond(this, getExcelSecond());
		setListAdapter(adapterSecond);
	}

	private void secFunction() {

		adapterSecond = new MyCustomArrayAdapterSecond(this, getModelSecond());
		setListAdapter(adapterSecond);
	}

	// 엑셀용 리스트
	private List<Model> getExcel(Intent intent) {
		list = new ArrayList<Model>();

		reverse = 1;
		loopCount = 0;

		fileName = intent.getExtras().get("fileName").toString();

		String dirPath = STRSAVEPATH;

		String line = "";
		BufferedReader bw = null;
		File file = new File(dirPath, fileName);
		try {
			bw = new BufferedReader(new InputStreamReader(new FileInputStream(file), "MS949"));

			while ((line = bw.readLine()) != null) {
				String[] cars = line.split(",");
				list.add(get(cars[0]));
				Log.i("INFO", "헹" + cars[0]);
				Log.i("INFO", "열" + cars[1]);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	private List<Model> getModel() {
		list = new ArrayList<Model>();

		JSONParser jParser = new JSONParser();

		AssetManager assetManager = getResources().getAssets();
		AssetInputStream ais = null;

		try {
			ais = (AssetInputStream) assetManager.open(jsonName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// String url = ais;
		// getting JSON string from URL
		JSONArray json = jParser.getJSONFromUrl(ais);

		count = json.length();

		for (int i = 0; i < json.length(); i++) {

			try {
				JSONObject c = json.getJSONObject(i);
				String vtype = c.getString(TAG_VOCA);

				// String vcolor = c.getString(TAG_SCRIPT);

				// String vcolor = c.getString(" ");

				list.add(get(vtype));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		list.get(1).setSelected(true); // select one item by default
		// list.get(2).setSelected(true); // select one item by default
		// list.get(3).setSelected(true); // select one item by default

		return list;
	}

	private Model get(String s) {
		return new Model(s);
	}

	private List<ModelSecond> getExcelSecond() {

		listSecond = new ArrayList<ModelSecond>();
		boolean cnt;
		mChildList001 = new ArrayList<String>();
		mChildList002 = new ArrayList<String>();

		String dirPath = STRSAVEPATH;

		String line = "";
		BufferedReader bw = null;

		count = list.size();
		File file = new File(dirPath, fileName);
		try {

			bw = new BufferedReader(new InputStreamReader(new FileInputStream(file), "MS949"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < count; i++) {
			try {
				line = bw.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] cars = line.split(",");
			cnt = list.get(i).isSelected();
			Log.i("INFO", "cnt : " + cnt);
			if (cnt) {
				listSecond.add(get(cars[0], cars[1]));
				mChildList001.add(cars[0]);
				mChildList002.add(cars[1]);
				countSecond++;
			}
		}
		return listSecond;
	}

	private List<ModelSecond> getModelSecond() {

		listSecond = new ArrayList<ModelSecond>();

		JSONParser jParser = new JSONParser();

		AssetManager assetManager = getResources().getAssets();
		AssetInputStream ais = null;

		try {
			ais = (AssetInputStream) assetManager.open(jsonName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// String url = ais;
		// getting JSON string from URL
		JSONArray json = jParser.getJSONFromUrl(ais);

		count = json.length();
		boolean cnt;
		mChildList001 = new ArrayList<String>();
		mChildList002 = new ArrayList<String>();

		for (int i = 0; i < json.length(); i++) {

			cnt = list.get(i).isSelected();
			Log.i("test", " Selected(" + i + "): " + cnt);

			try {
				JSONObject c = json.getJSONObject(i);
				String vtype = c.getString(TAG_VOCA);
				String vcolor = c.getString(TAG_SCRIPT);

				if (cnt) {
					listSecond.add(get(vtype, vcolor));

					mChildList001.add(vtype);
					mChildList002.add(vcolor);

					countSecond++;
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listSecond;
	}

	/**
	 * ���丮 ����
	 * 
	 * @return dir
	 */
	private File makeDirectory(String dir_path) {
		File dir = new File(dir_path);
		if (!dir.exists()) {
			dir.mkdirs();
			Log.i(TAG, "!dir.exists");
		} else {
			Log.i(TAG, "dir.exists");
		}

		return dir;
	}

	/**
	 * ���� ����
	 * 
	 * @param dir
	 * @return file
	 */
	private File makeFile(File dir, String file_path) {
		File file = null;
		boolean isSuccess = false;
		if (dir.isDirectory()) {
			file = new File(file_path);
			if (file != null && !file.exists()) {
				Log.i(TAG, "!file.exists");
				try {
					isSuccess = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					Log.i(TAG, "���ϻ��� ���� = " + isSuccess);
				}
			} else {
				Log.i(TAG, "file.exists");
			}
		}
		return file;
	}

	private ModelSecond get(String s, String place) {
		return new ModelSecond(s, place);
	}

	class MyThread extends Thread {
		public void run() {
			for (int i = 0; i < mChildList001.size(); i++) {

				for (int j = 0; j < (i + 1); j++) {
					try {
						Thread.sleep(1500);
					} catch (Exception e) {
					}
					;

					Message msg = new Message();
					msg.arg1 = j;
					msg.arg2 = i;
					handler.sendMessage(msg);
				}
			}
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
			;
			Message msg = new Message();
			msg.arg1 = 1000;
			handler.sendMessage(msg);
		}
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			int value = msg.arg1;

			if (value == 1000) {
				btnApple003.setText("Repeat");
				return;
			}

			if (reverse != 100) {
				int total = msg.arg2 + 1;
				int valuePlus = msg.arg1 + 1;
				String changTitle = "Remember (" + valuePlus + "/" + countSecond + ") - " + total;
				btnApple003.setText(changTitle);
				vocabulary.setText(mChildList001.get(value));

				if (loopCount > 2)
					script.setText("");
				else
					script.setText(mChildList002.get(value));

			} else {
				int total = countSecond - msg.arg2;
				int valuePlus = countSecond - msg.arg1;
				String changTitle = "Remember (" + valuePlus + "/" + countSecond + ") - " + total;
				btnApple003.setText(changTitle);
				value = countSecond - (value + 1);
				vocabulary.setText(mChildList001.get(value));

				if (loopCount > 2)
					script.setText("");
				else
					script.setText(mChildList002.get(value));

			}

		}
	};

}
