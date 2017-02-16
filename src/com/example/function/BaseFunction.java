package com.example.function;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.app.MainVolley;
import com.example.app.MyApplication;

import android.util.Log;
import android.widget.Toast;

public class BaseFunction {
	private int method;
	private String url;
	private JSONObject jsonRequest;
	private JSONObject jsonResponse;
	private long lastRequestTime;
	private long currentRequestTime;

	public BaseFunction(int method, String url, JSONObject jsonRequest) {
		this.method = method;
		this.url = url;
		this.jsonRequest = jsonRequest;
		lastRequestTime = new Date().getTime();
		currentRequestTime = new Date().getTime();
		work();
	}

	public void run() {
		currentRequestTime = new Date().getTime();
		if (currentRequestTime - lastRequestTime >= 1000 * 60 * 5) {
			lastRequestTime = currentRequestTime;
			work();
		}
	}

	public void work() {
		if (jsonRequest != null) {
			Log.d(getTag(), "request:" + jsonRequest.toString());
		} else {
			Log.d(getTag(), "request:" + url);
		}
		MainVolley.getRequestQueue().add(new JsonObjectRequest(method, url, jsonRequest, new Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				Log.d(getTag(), "response:" + response.toString());
				jsonResponse = response;
				String code = "1"; // 默认失败
				try {
					code = response.getString("code");
				} catch (JSONException e) {
					e.printStackTrace();
				}

//				code0Response();

			}

		}, new Response.ErrorListener() {

			public void onErrorResponse(VolleyError error) {
				showToast(MainVolley.ErrorMessage(error));
//				errorResponse();
			}

		}));
	}

	// 手动获取返回结果
	public JSONObject getJsonResponse() {
		return jsonResponse;
	}

//	// 操作成功
//	protected void code0Response() {
//
//	}
//
//	// 操作失败
//	protected void code1Response() {
//
//	}
//
//	// Token 错误
//	protected void code2Response() {
//
//	}
//
//	// Token 过期
//	protected void code3Response() {
//
//	}
//
//	// 网络连接失败
//	protected void errorResponse() {
//
//	}

	private String getTag() {
		return getClass().getSimpleName();
	}

	protected void showToast(String str) {
		Toast.makeText(MyApplication.getContext(), str, Toast.LENGTH_SHORT).show();
	}

	protected void showToast(int resId) {
		Toast.makeText(MyApplication.getContext(), resId, Toast.LENGTH_SHORT).show();
	}

}
