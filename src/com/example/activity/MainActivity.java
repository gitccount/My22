package com.example.activity;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.app.BaseActivity;
import com.example.function.QueryString;
import com.example.myvolley.R;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

	private Toolbar mToolbar;
	private TextView tvMain;
	// private static String url =
	// "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js";
	private static String url = "https://api.map.baidu.com/location/ip?ip=14.153.159.145&ak=zpvdXSfIcc9Ati36qOS9a4KWcEHfIq3g&coor=bd09ll";

	@Override
	protected void initVariables() {

	}

	@Override
	protected void initViews(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		//关爱生活，人人有责
		Log.i(getTag(), "OnCreat");
		mToolbar = (Toolbar) findViewById(R.id.toolbar_activity_main);
		tvMain = (TextView) findViewById(R.id.tv_main);
		mToolbar.setTitle("");
		setSupportActionBar(mToolbar);
		mToolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_36dp);
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		JSONObject jsonRequest = new JSONObject();
		try {
			jsonRequest.put("IDSBG", "IDSBG");
			jsonRequest.put("strFactory", "深圳龙华生活园区");
			jsonRequest.put("strNoticeType", "1");
			jsonRequest.put("strSysName", "EKnown");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<String, String> map=new HashMap<>();
		map.put("123", "456");
		map.put("789", "1111");
		map.put("就爱你支队", "咳咳咳");
		new QueryString(map) {
			
			protected void code0Response() {

				tvMain.setText(getStrResponse());
			}
		};
	}
}
