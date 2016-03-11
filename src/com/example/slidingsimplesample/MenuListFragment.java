package com.example.slidingsimplesample;

import java.io.File;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;

import android.R.array;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MenuListFragment extends ListFragment {
	Button btn_home;
	Button btn_downloader;
	final int PICKFILE_RESULT_CODE = 1;
	private static final int File_List = 1;
	static File Path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	public static final String STRSAVEPATH = Path.getPath();
	ArrayAdapter<String> adapter;
	List<String> list;
	List<String> bookmark;
	SharedPreferences sp;
	SharedPreferences.Editor mEdit1;
	Intent oneDay;

	public MenuListFragment() {
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.menu_list, null);
		// adapter = new SampleAdapter(v.getContext());
		btn_home = (Button) v.findViewById(R.id.btn_home);
		btn_downloader = (Button) v.findViewById(R.id.btn_downloader);

		// setup peferences
		sp = getActivity().getSharedPreferences("EnglishList", 0);
		mEdit1 = sp.edit();

		// 객체 생성 및 초기화
		list = new ArrayList<String>();
		bookmark = new ArrayList<String>();
		((Globals) getActivity().getApplication()).setList(list);

		// Set<String> set = new LinkedHashSet<String>();
		// set = sp.getStringSet("EnglishList", null);

		int set = sp.getInt("listSize", -1);
		int bookmark_size = sp.getInt("bookmark_size", 0);

		if (bookmark_size != 0) {
			// 북마크 불러오기
			for (int i = 0; i < bookmark_size; i++) {
				//mEdit1.remove("bookmark" + String.valueOf(i));
				//mEdit1.putInt("bookmark_size", 0);
				//mEdit1.commit();
				bookmark.add(i, sp.getString("bookmark" + i, null));
			}
		}

		Log.i("INFO", "불러올 데이터의 크기 : " + String.valueOf(set));

		if (set == -1 || set == 0) {
			((Globals) getActivity().getApplication()).adpaterInit();
		} else {
			for (int i = 0; i < set; i++) {
				// mEdit1.remove("EnglishList" + String.valueOf(i));
				// mEdit1.putInt("listSize", 0);
				// mEdit1.commit();
				list.add(i, sp.getString("EnglishList" + i, null));
			}
			((Globals) getActivity().getApplication()).setList(list);
		}

		list = ((Globals) getActivity().getApplication()).getAdapter();
		adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, list);

		Button btn_Add = (Button) v.findViewById(R.id.btn_add);
		Button btn_Quick = (Button) v.findViewById(R.id.btn_quick);
		oneDay = new Intent(this.getActivity(), ExcelModelListViewActivity.class);

		// 홈버튼 클릭 시
		btn_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((BaseActivity) getActivity()).fragmentReplace(100);
			}
		});

		// 다운로더 버튼 클릭 시
		btn_downloader.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((BaseActivity) getActivity()).fragmentReplace(101);
			}
		});

		// 추가버튼 클릭 시
		btn_Add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(),
						android.R.layout.select_dialog_singlechoice);

				String dirPath = STRSAVEPATH;
				File file = new File(dirPath);

				for (File f : file.listFiles()) {
					if (f.getName().contains(".")) {
						String token[] = f.getName().split("[.]");
						if (token[1].equals("csv")) {
							arrayAdapter.add(f.getName());
						}
					}
				}

				AlertDialog alert = new AlertDialog.Builder(v.getContext()).setIcon(R.drawable.ic_launcher)
						.setTitle("다운로드")

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

								oneDay.putExtra("name", "all");
								oneDay.putExtra("fileName", arrayAdapter.getItem(which));

								// 리스트 추가
								String token[] = arrayAdapter.getItem(which).split("[.]");
								String str = token[0];
								adapter.add(str);
								setListAdapter(adapter);
								((Globals) getActivity().getApplication()).setList(list);
								// sp =
								// getActivity().getSharedPreferences("EnglishList",
								// 0);
								// mEdit1 = sp.edit();

								// Set<String> set = new
								// LinkedHashSet<String>();

								for (int i = 0; i < list.size(); i++) {
									mEdit1.putString("EnglishList" + i, list.get(i));
									mEdit1.commit();
								}
								mEdit1.putInt("listSize", list.size());
								mEdit1.commit();

								// 액티비티실행
								startActivity(oneDay);
							}
						}).show();

			}
		});

		// 즐겨찾기 버튼 클릭
		btn_Quick.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				DialogInterface mPopupDlg = null;
				final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(),
						android.R.layout.simple_list_item_1, bookmark);

				Log.i("INFO", "북마크 사이즈 : "+ String.valueOf(bookmark.size()));
				if (bookmark.size() == 0) {
					arrayAdapter.add("등록된 영어 단어장이 없습니다.");
				}
				AlertDialog alert = new AlertDialog.Builder(v.getContext()).setTitle("즐겨찾기")
						.setIcon(R.drawable.ic_launcher)

						.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								if (arrayAdapter.getItem(0).equals("등록된 영어 단어장이 없습니다.")) {
									arrayAdapter.remove("등록된 영어 단어장이 없습니다.");
								}
							}
						}).setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								String filename = arrayAdapter.getItem(which);
								if (filename.equals("토플")) {
									SelectItem(0);
								} else if (filename.equals("기본영단어1")) {
									SelectItem(1);
								} else if (filename.equals("기본영단어2")) {
									SelectItem(2);
								} else {
									Log.i("INFO", "하잇");
									String filename1 = arrayAdapter.getItem(which)+".csv";
									oneDay.putExtra("name", "all");
									oneDay.putExtra("fileName", filename1);
									startActivity(oneDay);
								}

							}
						}).show();
			}

		});

		return v;

	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// SampleAdapter adapter = new SampleAdapter(getActivity());
		// adapter.add(new SampleItem("토플", android.R.drawable.ic_menu_search));

		setListAdapter(adapter);

		getListView().setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
				// TODO Auto-generated method stub
				final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(v.getContext(),
						android.R.layout.simple_list_item_1);

				// 포지션 위치구분
				if (position < 3) {
					arrayAdapter.add("즐겨찾기에 추가");
				} else {
					arrayAdapter.add("즐겨찾기에 추가");
					arrayAdapter.add("목록에서 삭제");
				}

				final int pos = position;
				AlertDialog alert = new AlertDialog.Builder(v.getContext()).setIcon(R.drawable.ic_launcher)

						.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// 취소
							}
						})

						.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
							// .setSingleChoiceItems(strItems, -1, new
							// DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {

								if (arrayAdapter.getItem(which).equals("즐겨찾기에 추가")) {

									bookmark.add(list.get(pos));

									for (int i = 0; i < bookmark.size(); i++) {
										mEdit1.putString("bookmark" + i, bookmark.get(i));
									}

									mEdit1.putInt("bookmark_size", bookmark.size());
									mEdit1.commit();
								} else {
									// 리스트 삭제

									int size = list.size() - pos;
									// 위치 옮기기 및 preference 삭제
									Log.i("INFO", String.valueOf(size));

									if (size == 1) {
										mEdit1.remove("EnglishList" + String.valueOf(pos));
									} else {
										for (int i = pos; i < list.size() - 1; i++) {
											mEdit1.putString("EnglishList" + String.valueOf(i), list.get(i + 1));
											Log.i("INFO",
													"EnglishList" + String.valueOf(i) + "에 넣을 값은 : " + list.get(i + 1));
										}
										Log.i("INFO", "지울 인덱스 : " + String.valueOf(list.size() - 1));
										mEdit1.remove("EnglishList" + String.valueOf(list.size() - 1));
									}

									// 삭제 (리스트삭제, 어뎁터 업데이트)
									adapter.remove(list.get(pos));

									((Globals) getActivity().getApplication()).setList(list);

									mEdit1.putInt("listSize", list.size());
									Log.i("INFO", "삭제 후 리스트 사이즈  : " + String.valueOf(list.size()));

									mEdit1.commit();

									sp = getActivity().getSharedPreferences("EnglishList", 0);
									mEdit1 = sp.edit();
									for (int i = 0; i < list.size(); i++) {
										Log.i("INFO", "list 값  : " + list.get(i));
										Log.i("INFO", "저장 값  : " + sp.getString("EnglishList" + i, null));
									}
								}

							}
						}).show();
				return true;
			}
		});

	}

	public void SelectItem(int index) {
		if (index < 3) {
			((BaseActivity) getActivity()).fragmentReplace(index);
		} else if (index >= 3) {

			String filename = adapter.getItem(index) + ".csv";

			oneDay.putExtra("name", "all");
			oneDay.putExtra("fileName", filename);

			startActivity(oneDay);
			// Custom 영단어 실행
		} else {
			// error
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		SelectItem(position);

		super.onListItemClick(l, v, position, id);
	}

}