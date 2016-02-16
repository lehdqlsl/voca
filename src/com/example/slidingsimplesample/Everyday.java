package com.example.slidingsimplesample;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Everyday extends Activity implements View.OnClickListener {

	final int PICKFILE_RESULT_CODE = 1;
	private static final int File_List = 1;
	static File Path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	public static final String STRSAVEPATH = Path.getPath();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.everyday_main);

		TextView btnApple001 = (TextView) findViewById(R.id.button1);
		TextView btnApple002 = (TextView) findViewById(R.id.button2);
		TextView btnApple003 = (TextView) findViewById(R.id.button3);
		TextView btnApple004 = (TextView) findViewById(R.id.button4);
		TextView btnApple005 = (TextView) findViewById(R.id.button5);
		TextView btnApple006 = (TextView) findViewById(R.id.button6);
		TextView btnApple007 = (TextView) findViewById(R.id.button7);
		TextView btnApple008 = (TextView) findViewById(R.id.button8);
		TextView btnApple009 = (TextView) findViewById(R.id.button9);
		TextView btnApple010 = (TextView) findViewById(R.id.button10);

		TextView btnApple011 = (TextView) findViewById(R.id.button11);
		TextView btnApple012 = (TextView) findViewById(R.id.button12);
		TextView btnApple013 = (TextView) findViewById(R.id.button13);
		TextView btnApple014 = (TextView) findViewById(R.id.button14);
		TextView btnApple015 = (TextView) findViewById(R.id.button15);
		TextView btnApple016 = (TextView) findViewById(R.id.button16);
		TextView btnApple017 = (TextView) findViewById(R.id.button17);
		TextView btnApple018 = (TextView) findViewById(R.id.button18);
		TextView btnApple019 = (TextView) findViewById(R.id.button19);
		TextView btnApple020 = (TextView) findViewById(R.id.button20);

		TextView btnApple021 = (TextView) findViewById(R.id.button21);
		TextView btnApple022 = (TextView) findViewById(R.id.button22);
		TextView btnApple023 = (TextView) findViewById(R.id.button23);
		TextView btnApple024 = (TextView) findViewById(R.id.button24);
		TextView btnApple025 = (TextView) findViewById(R.id.button25);
		TextView btnApple026 = (TextView) findViewById(R.id.button26);
		TextView btnApple027 = (TextView) findViewById(R.id.button27);
		TextView btnApple028 = (TextView) findViewById(R.id.button28);
		TextView btnApple029 = (TextView) findViewById(R.id.button29);
		TextView btnApple030 = (TextView) findViewById(R.id.button30);

		TextView btnApple031 = (TextView) findViewById(R.id.button31);
		TextView btnApple032 = (TextView) findViewById(R.id.button32);
		TextView btnApple033 = (TextView) findViewById(R.id.button33);
		TextView btnApple034 = (TextView) findViewById(R.id.button34);
		TextView btnApple035 = (TextView) findViewById(R.id.button35);
		TextView btnApple036 = (TextView) findViewById(R.id.button36);
		TextView btnApple037 = (TextView) findViewById(R.id.button37);
		TextView btnApple038 = (TextView) findViewById(R.id.button38);
		TextView btnApple039 = (TextView) findViewById(R.id.button39);
		TextView btnApple040 = (TextView) findViewById(R.id.button40);

		TextView btnApple041 = (TextView) findViewById(R.id.button41);
		TextView btnApple042 = (TextView) findViewById(R.id.button42);
		TextView btnApple043 = (TextView) findViewById(R.id.button43);
		TextView btnApple044 = (TextView) findViewById(R.id.button44);
		TextView btnApple045 = (TextView) findViewById(R.id.button45);
		TextView btnApple046 = (TextView) findViewById(R.id.button46);
		TextView btnApple047 = (TextView) findViewById(R.id.button47);
		TextView btnApple048 = (TextView) findViewById(R.id.button48);
		TextView btnApple049 = (TextView) findViewById(R.id.button49);
		TextView btnApple050 = (TextView) findViewById(R.id.button50);

		TextView btnApple051 = (TextView) findViewById(R.id.button51);
		TextView btnApple052 = (TextView) findViewById(R.id.button52);
		TextView btnApple053 = (TextView) findViewById(R.id.button53);
		TextView btnApple054 = (TextView) findViewById(R.id.button54);
		TextView btnApple055 = (TextView) findViewById(R.id.button55);
		TextView btnApple056 = (TextView) findViewById(R.id.button56);
		TextView btnApple057 = (TextView) findViewById(R.id.button57);
		TextView btnApple058 = (TextView) findViewById(R.id.button58);
		TextView btnApple059 = (TextView) findViewById(R.id.button59);
		TextView btnApple060 = (TextView) findViewById(R.id.button60);

		TextView btnApple100 = (TextView) findViewById(R.id.button100);

		btnApple001.setOnClickListener(this);
		btnApple002.setOnClickListener(this);
		btnApple003.setOnClickListener(this);
		btnApple004.setOnClickListener(this);
		btnApple005.setOnClickListener(this);
		btnApple006.setOnClickListener(this);
		btnApple007.setOnClickListener(this);
		btnApple008.setOnClickListener(this);
		btnApple009.setOnClickListener(this);
		btnApple010.setOnClickListener(this);

		btnApple011.setOnClickListener(this);
		btnApple012.setOnClickListener(this);
		btnApple013.setOnClickListener(this);
		btnApple014.setOnClickListener(this);
		btnApple015.setOnClickListener(this);
		btnApple016.setOnClickListener(this);
		btnApple017.setOnClickListener(this);
		btnApple018.setOnClickListener(this);
		btnApple019.setOnClickListener(this);
		btnApple020.setOnClickListener(this);

		btnApple021.setOnClickListener(this);
		btnApple022.setOnClickListener(this);
		btnApple023.setOnClickListener(this);
		btnApple024.setOnClickListener(this);
		btnApple025.setOnClickListener(this);
		btnApple026.setOnClickListener(this);
		btnApple027.setOnClickListener(this);
		btnApple028.setOnClickListener(this);
		btnApple029.setOnClickListener(this);
		btnApple030.setOnClickListener(this);

		btnApple031.setOnClickListener(this);
		btnApple032.setOnClickListener(this);
		btnApple033.setOnClickListener(this);
		btnApple034.setOnClickListener(this);
		btnApple035.setOnClickListener(this);
		btnApple036.setOnClickListener(this);
		btnApple037.setOnClickListener(this);
		btnApple038.setOnClickListener(this);
		btnApple039.setOnClickListener(this);
		btnApple040.setOnClickListener(this);

		btnApple041.setOnClickListener(this);
		btnApple042.setOnClickListener(this);
		btnApple043.setOnClickListener(this);
		btnApple044.setOnClickListener(this);
		btnApple045.setOnClickListener(this);
		btnApple046.setOnClickListener(this);
		btnApple047.setOnClickListener(this);
		btnApple048.setOnClickListener(this);
		btnApple049.setOnClickListener(this);
		btnApple050.setOnClickListener(this);

		btnApple051.setOnClickListener(this);
		btnApple052.setOnClickListener(this);
		btnApple053.setOnClickListener(this);
		btnApple054.setOnClickListener(this);
		btnApple055.setOnClickListener(this);
		btnApple056.setOnClickListener(this);
		btnApple057.setOnClickListener(this);
		btnApple058.setOnClickListener(this);
		btnApple059.setOnClickListener(this);
		btnApple060.setOnClickListener(this);

		btnApple100.setOnClickListener(this);

		/*
		 * Button btnApple=(Button)findViewById(R.id.button1);
		 * btnApple.setOnClickListener(this); Button
		 * btnOrange=(Button)findViewById(R.id.button2);
		 * btnOrange.setOnClickListener(this);
		 */
	}

	public void onClick(View v) {
		final Intent oneDay = new Intent(this, ModelListViewActivity.class);

		switch (v.getId()) {
		case R.id.button1:
			oneDay.putExtra("name", "1");
			startActivity(oneDay);
			break;
		case R.id.button2:
			oneDay.putExtra("name", "2");
			startActivity(oneDay);
			break;
		case R.id.button3:
			oneDay.putExtra("name", "3");
			startActivity(oneDay);
			break;
		case R.id.button4:
			oneDay.putExtra("name", "4");
			startActivity(oneDay);
			break;
		case R.id.button5:
			oneDay.putExtra("name", "5");
			startActivity(oneDay);
			break;
		case R.id.button6:
			oneDay.putExtra("name", "6");
			startActivity(oneDay);
			break;
		case R.id.button7:
			oneDay.putExtra("name", "7");
			startActivity(oneDay);
			break;
		case R.id.button8:
			oneDay.putExtra("name", "8");
			startActivity(oneDay);
			break;
		case R.id.button9:
			oneDay.putExtra("name", "9");
			startActivity(oneDay);
			break;
		case R.id.button10:
			oneDay.putExtra("name", "10");
			startActivity(oneDay);
			break;
		case R.id.button11:
			oneDay.putExtra("name", "11");
			startActivity(oneDay);
			break;
		case R.id.button12:
			oneDay.putExtra("name", "12");
			startActivity(oneDay);
			break;
		case R.id.button13:
			oneDay.putExtra("name", "13");
			startActivity(oneDay);
			break;
		case R.id.button14:
			oneDay.putExtra("name", "14");
			startActivity(oneDay);
			break;
		case R.id.button15:
			oneDay.putExtra("name", "15");
			startActivity(oneDay);
			break;
		case R.id.button16:
			oneDay.putExtra("name", "16");
			startActivity(oneDay);
			break;
		case R.id.button17:
			oneDay.putExtra("name", "17");
			startActivity(oneDay);
			break;
		case R.id.button18:
			oneDay.putExtra("name", "18");
			startActivity(oneDay);
			break;
		case R.id.button19:
			oneDay.putExtra("name", "19");
			startActivity(oneDay);
			break;
		case R.id.button20:
			oneDay.putExtra("name", "20");
			startActivity(oneDay);
			break;
		case R.id.button21:
			oneDay.putExtra("name", "21");
			startActivity(oneDay);
			break;
		case R.id.button22:
			oneDay.putExtra("name", "22");
			startActivity(oneDay);
			break;
		case R.id.button23:
			oneDay.putExtra("name", "23");
			startActivity(oneDay);
			break;
		case R.id.button24:
			oneDay.putExtra("name", "24");
			startActivity(oneDay);
			break;
		case R.id.button25:
			oneDay.putExtra("name", "25");
			startActivity(oneDay);
			break;
		case R.id.button26:
			oneDay.putExtra("name", "26");
			startActivity(oneDay);
			break;
		case R.id.button27:
			oneDay.putExtra("name", "27");
			startActivity(oneDay);
			break;
		case R.id.button28:
			oneDay.putExtra("name", "28");
			startActivity(oneDay);
			break;
		case R.id.button29:
			oneDay.putExtra("name", "29");
			startActivity(oneDay);
			break;
		case R.id.button30:
			oneDay.putExtra("name", "30");
			startActivity(oneDay);
			break;
		case R.id.button31:
			oneDay.putExtra("name", "31");
			startActivity(oneDay);
			break;
		case R.id.button32:
			oneDay.putExtra("name", "32");
			startActivity(oneDay);
			break;
		case R.id.button33:
			oneDay.putExtra("name", "33");
			startActivity(oneDay);
			break;
		case R.id.button34:
			oneDay.putExtra("name", "34");
			startActivity(oneDay);
			break;
		case R.id.button35:
			oneDay.putExtra("name", "35");
			startActivity(oneDay);
			break;
		case R.id.button36:
			oneDay.putExtra("name", "36");
			startActivity(oneDay);
			break;
		case R.id.button37:
			oneDay.putExtra("name", "37");
			startActivity(oneDay);
			break;
		case R.id.button38:
			oneDay.putExtra("name", "38");
			startActivity(oneDay);
			break;
		case R.id.button39:
			oneDay.putExtra("name", "39");
			startActivity(oneDay);
			break;
		case R.id.button40:
			oneDay.putExtra("name", "40");
			startActivity(oneDay);
			break;
		case R.id.button41:
			oneDay.putExtra("name", "41");
			startActivity(oneDay);
			break;
		case R.id.button42:
			oneDay.putExtra("name", "42");
			startActivity(oneDay);
			break;
		case R.id.button43:
			oneDay.putExtra("name", "43");
			startActivity(oneDay);
			break;
		case R.id.button44:
			oneDay.putExtra("name", "44");
			startActivity(oneDay);
			break;
		case R.id.button45:
			oneDay.putExtra("name", "45");
			startActivity(oneDay);
			break;
		case R.id.button46:
			oneDay.putExtra("name", "46");
			startActivity(oneDay);
			break;
		case R.id.button47:
			oneDay.putExtra("name", "47");
			startActivity(oneDay);
			break;
		case R.id.button48:
			oneDay.putExtra("name", "48");
			startActivity(oneDay);
			break;
		case R.id.button49:
			oneDay.putExtra("name", "49");
			startActivity(oneDay);
			break;
		case R.id.button50:
			oneDay.putExtra("name", "50");
			startActivity(oneDay);
			break;
		case R.id.button51:
			oneDay.putExtra("name", "51");
			startActivity(oneDay);
			break;
		case R.id.button52:
			oneDay.putExtra("name", "52");
			startActivity(oneDay);
			break;
		case R.id.button53:
			oneDay.putExtra("name", "53");
			startActivity(oneDay);
			break;
		case R.id.button54:
			oneDay.putExtra("name", "54");
			startActivity(oneDay);
			break;
		case R.id.button55:
			oneDay.putExtra("name", "55");
			startActivity(oneDay);
			break;
		case R.id.button56:
			oneDay.putExtra("name", "56");
			startActivity(oneDay);
			break;
		case R.id.button57:
			oneDay.putExtra("name", "57");
			startActivity(oneDay);
			break;
		case R.id.button58:
			oneDay.putExtra("name", "58");
			startActivity(oneDay);
			break;
		case R.id.button59:
			oneDay.putExtra("name", "59");
			startActivity(oneDay);
			break;
		case R.id.button60:
			oneDay.putExtra("name", "60");
			startActivity(oneDay);
			break;
		case R.id.button100:
			final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
					android.R.layout.select_dialog_singlechoice);

			String dirPath = STRSAVEPATH;
			File file = new File(dirPath);

			if (file.listFiles().length > 0)
				for (File f : file.listFiles()) {
					String token[] = f.getName().split("[.]");
					if (token[1].equals("csv")) {
						arrayAdapter.add(f.getName());
					}
				}

			AlertDialog alert = new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher).setTitle("AlertTitle")

					.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					})

					.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
						// .setSingleChoiceItems(strItems, -1, new
						// DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							String msg = "";
							msg = "Load the" + arrayAdapter.getItem(which);
							Toast.makeText(Everyday.this, msg, Toast.LENGTH_SHORT).show();

							oneDay.putExtra("name", "all");
							oneDay.putExtra("fileName", arrayAdapter.getItem(which));
							startActivity(oneDay);

							/*
							 * String msg = ""; switch ( which ) { case 0:
							 * 
							 * msg = "Item 1 Selected " +
							 * arrayAdapter.getItem(which); break; case 1: msg =
							 * "Item 2 Selected " + arrayAdapter.getItem(which);
							 * break; case 2: msg = "Item 3 Selected " +
							 * arrayAdapter.getItem(which); break; }
							 * 
							 */

						}
					}).show();

			/*
			 * Intent intent = new Intent();
			 * intent.setAction(Intent.ACTION_PICK); Uri startDir =
			 * Uri.fromFile(new File("/mnt/sdcard/vocafolder/"));
			 * startActivityForResult(intent, PICK_REQUEST_CODE);
			 */

			/*
			 * AlertDialog.Builder builderSingle = new
			 * AlertDialog.Builder(this);
			 * builderSingle.setIcon(R.drawable.ic_launcher);
			 * builderSingle.setTitle("Select One Name:-"); final
			 * ArrayAdapter<String> arrayAdapter = new
			 * ArrayAdapter<String>(this,
			 * android.R.layout.select_dialog_singlechoice);
			 * arrayAdapter.add("Hardik"); arrayAdapter.add("Archit");
			 * arrayAdapter.add("Jignesh"); arrayAdapter.add("Umang");
			 * arrayAdapter.add("Gatti");
			 * 
			 * builderSingle.setNegativeButton("cancel", new
			 * DialogInterface.OnClickListener() {
			 * 
			 * @Override public void onClick(DialogInterface dialog, int which)
			 * { dialog.dismiss(); } });
			 * 
			 * builderSingle.setAdapter(arrayAdapter, new
			 * DialogInterface.OnClickListener() {
			 * 
			 * @Override public void onClick(DialogInterface dialog, int which)
			 * { String strName = arrayAdapter.getItem(which);
			 * AlertDialog.Builder builderInner = new AlertDialog.Builder(this);
			 * 
			 * //AlertDialog.Builder builderInner = new
			 * AlertDialog.Builder(this); builderInner.setMessage(strName);
			 * builderInner.setTitle("Your Selected Item is");
			 * builderInner.setPositiveButton("Ok", new
			 * DialogInterface.OnClickListener() {
			 * 
			 * @Override public void onClick( DialogInterface dialog, int which)
			 * { dialog.dismiss(); } }); builderInner.show(); } });
			 * builderSingle.show();
			 * 
			 * 
			 */

			break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case File_List: {
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				String filePath = uri.getPath();

				Intent oneDay = new Intent(this, ModelListViewActivity.class);
				oneDay.putExtra("name", "all");
				oneDay.putExtra("filePath", filePath);

				startActivity(oneDay);

			}
		}
		}
	}

}
