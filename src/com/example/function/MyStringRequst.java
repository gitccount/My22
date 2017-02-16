package com.example.function;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.app.MainVolley;
import com.example.app.MyApplication;

import android.util.Log;
import android.widget.Toast;

public class MyStringRequst {
	private int method;
	private String url;
	private String Strresponse;
	private long lastRequestTime;
	private long currentRequestTime;
	Map<String, String> map;

	public MyStringRequst(int method, String url, HashMap<String, String> map2) {
		this.method = method;
		this.url = url;
		lastRequestTime = new Date().getTime();
		currentRequestTime = new Date().getTime();
		map = new HashMap<String, String>();
		map=map2;
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
		if (map != null) {
			StringBuffer stb=new StringBuffer();
			  for (String key : map.keySet()) {
				  stb.append("key= "+ key + " and value= " + map.get(key)+"\n");
//				   System.out.println("key= "+ key + " and value= " + map.get(key));
				  }
			Log.d(getTag(), "request:" + stb.toString());
		} else {
			Log.d(getTag(), "request:" + url);
		}
		MainVolley.getRequestQueue().add(new StringRequest(method, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				Log.i(getTag(), response);
				Strresponse=response;
				code0Response();
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				showToast(MainVolley.ErrorMessage(error));
			}
		}){
//			protected Map<String, String> getParams(){
//				return map;
//			}
			
//			protected Map<String, String> getParams() throws AuthFailureError {
//				Map<String, String> map3 = new HashMap<String, String>();
//				return map;
//			}
		});
		/*
		 * MainVolley.getRequestQueue().add(new JsonObjectRequest(method, url,
		 * jsonRequest, new Listener<JSONObject>() {
		 * 
		 * @Override public void onResponse(JSONObject response) {
		 * Log.d(getTag(), "response:" + response.toString()); jsonResponse =
		 * response; String code = "1"; // 默认失败 try { code =
		 * response.getString("code"); } catch (JSONException e) {
		 * e.printStackTrace(); }
		 * 
		 * // code0Response();
		 * 
		 * }
		 * 
		 * }, new Response.ErrorListener() {
		 * 
		 * public void onErrorResponse(VolleyError error) {
		 * showToast(MainVolley.ErrorMessage(error)); // errorResponse(); }
		 * 
		 * }));
		 */
	}

	// 手动获取返回结果
	public String getStrResponse(){
		return Strresponse;
		
	}
	// 用于调用类getStrResponse
	protected void code0Response() {

	}
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
