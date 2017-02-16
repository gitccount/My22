package com.example.function;

import org.json.JSONObject;

import com.android.volley.Request.Method;

public class QueryTest extends BaseFunction {
	private static String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js";

	public QueryTest(JSONObject jsonRequest) {
		super(Method.POST, url, jsonRequest);
	}

}
