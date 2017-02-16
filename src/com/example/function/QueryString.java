package com.example.function;

import java.util.HashMap;

import org.json.JSONObject;

import com.android.volley.Request.Method;

public class QueryString extends MyStringRequst {
	private static String url = "https://api.map.baidu.com/location/ip?ip=14.153.159.145&ak=zpvdXSfIcc9Ati36qOS9a4KWcEHfIq3g&coor=bd09ll";

	public QueryString(HashMap<String, String> map) {
		super(Method.GET, url, map);
	}

}
