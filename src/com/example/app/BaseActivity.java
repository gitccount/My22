package com.example.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity{
//	public abstract class BaseActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initVariables();
		initViews(savedInstanceState);
		MyApplication.addActivity(this);
	}
	
	@Override
	protected void onDestroy() {
		MyApplication.removeActivity(this);
		super.onDestroy();
	}
	
	protected abstract void initVariables();
	
	protected abstract void initViews(Bundle savedInstanceState);
	
	protected void showToast(String str) {
		Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT).show();
	}
	
	protected void showToast(int resId) {
		Toast.makeText(MyApplication.getContext(), resId, Toast.LENGTH_SHORT).show();
	}
	
	protected String getTag() {
		return getClass().getSimpleName();
	}
	
}
