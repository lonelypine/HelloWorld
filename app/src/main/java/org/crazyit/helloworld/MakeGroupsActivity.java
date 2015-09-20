package org.crazyit.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MakeGroupsActivity extends Activity {

	SharedPreferences  preferences;
	SharedPreferences.Editor editor;

	private ImageView top_back_iv;
	private TextView group1_tv;
	private TextView group2_tv;
	private TextView group3_tv;
	private TextView list1_tv;
	private TextView list2_tv;
	private TextView list3_tv;
	private Button save_btn;
	private Button exitYes_btn;
	private Button exitNo_btn;

	List list;
	String[] listString = { "杨词", "祝雨昕", "唐圣麟", "徐江南", "周志为", "黄雅卓", "邵媛媛", "申凯泽",
			"陈云佳", "赵子煜", "陈曦", "罗子璇" };

	Boolean SaveOrNo;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// 使用activity_main文件定义的界面布局
		setContentView(R.layout.activity_result);
		init();
		makeRandom();
		showResult();
		setListener();
	}

	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event) {
		if (SaveOrNo == false) {
			LinearLayout layout = (LinearLayout) getLayoutInflater()
					.inflate(R.layout.dialog_is_exit, null);
			AlertDialog.Builder isExit = new AlertDialog.Builder(this);

			final AlertDialog dialog;
			isExit.setView(layout).create();
			dialog = isExit.show();
			exitYes_btn = (Button) layout.findViewById(R.id.yes);
			exitNo_btn = (Button) layout.findViewById(R.id.no);

			exitYes_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});

			exitNo_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
		}	else
		finish();

		return false;
	}

	public void init() {
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		SaveOrNo = false;

		preferences = getSharedPreferences("helloworld",MODE_PRIVATE);
		editor = preferences.edit();


		top_back_iv = (ImageView) findViewById(R.id.top_back_iv);
		group1_tv = (TextView) findViewById(R.id.group1);
		group2_tv = (TextView) findViewById(R.id.group2);
		group2_tv = (TextView) findViewById(R.id.group3);
		list1_tv = (TextView) findViewById(R.id.list1);
		list2_tv = (TextView) findViewById(R.id.list2);
		list3_tv = (TextView) findViewById(R.id.list3);
		save_btn = (Button) findViewById(R.id.save);
	}

	public void makeRandom() {
		list = Arrays.asList(listString);
		Collections.shuffle(list);
		listString = (String[])list.toArray();
	}

	public void showResult() {
		list1_tv.setText(listString[1] + "  " + listString[2] + "  " + listString[3] + "  " + listString[0]);
		list2_tv.setText(listString[4] + "  " + listString[5] + "  " + listString[6] + "  " + listString[10]);
		list3_tv.setText(listString[7] + "  " + listString[8] + "  " + listString[9] + "  " + listString[11]);
	}

	public void setListener() {
		top_back_iv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (SaveOrNo == false) {
					LinearLayout layout = (LinearLayout) getLayoutInflater()
							.inflate(R.layout.dialog_is_exit, null);
					AlertDialog.Builder isExit = new AlertDialog.Builder(MakeGroupsActivity.this);

					final AlertDialog dialog;
					isExit.setView(layout).create();
					dialog = isExit.show();
					exitYes_btn = (Button) layout.findViewById(R.id.yes);
					exitNo_btn = (Button) layout.findViewById(R.id.no);

					exitYes_btn.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							finish();
						}
					});

					exitNo_btn.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
				}
				else
					finish();
			}
		});

		save_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				for (int i = 0; i < listString.length; i++) {
					editor.putString("list" + Integer.toString(i), listString[i]);
					editor.commit();
				}
				SaveOrNo = true;
				Toast toast = Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 120);
				toast.show();
			}
		});
	}
}