package com.example.app;

import android.app.Fragment;
import android.widget.Toast;

public class BaseFragment extends Fragment {
	protected void showToast(String str) {
		Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT).show();
	}

	protected void showToast(int resId) {
		Toast.makeText(MyApplication.getContext(), resId, Toast.LENGTH_SHORT).show();
	}
	
	protected String getLogTag() {
		return getClass().getSimpleName();
	}
}
