/**
 * 
 */
package com.example.app;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

public class MainVolley extends Volley {

	private static RequestQueue mRequestQueue;
    private static ImageLoader mImageLoader;


    private MainVolley() {
        // no instances
    }


    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);

        int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        // Use 1/8th of the available memory for this memory cache.
        int cacheSize = 1024 * 1024 * memClass / 8;
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(cacheSize));
    }


    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }


    /**
     * Returns instance of ImageLoader initialized with {@see FakeImageCache} which effectively means
     * that no memory caching is used. This is useful for images that you know that will be show
     * only once.
     * 
     * @return
     */
    public static ImageLoader getImageLoader() {
        if (mImageLoader != null) {
            return mImageLoader;
        } else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
    
    public static String ErrorMessage(VolleyError error){
    	String errorString=null;
    	if (error instanceof NetworkError) {
    		Log.d("Volley Error: ", "网络异常，请稍后重试！");
    		errorString="Volley Error: "+ "网络异常，请稍后重试！";
		} else if (error instanceof ServerError) {
			Log.d("Volley Error: ", "服务器故障，请稍后重试！");		
			errorString="Volley Error: "+ "服务器故障，请稍后重试！";
		} else if (error instanceof AuthFailureError) {
			Log.d("Volley Error: ", "身份验证失败，请稍后重试！");		
			errorString="Volley Error: "+ "身份验证失败，请稍后重试！";
		} else if (error instanceof NoConnectionError) {
			Log.d("Volley Error: ", "连接服务器失败，请稍后重试！");	
			errorString="Volley Error: "+ "连接服务器失败，请稍后重试！";
		} else if (error instanceof TimeoutError) {
			Log.d("Volley Error: ", "请求超时，请稍后重试！");
			errorString="Volley Error: "+"请求超时，请稍后重试！";
		} else if (error instanceof ParseError) {
			Log.d("Volley Error: ", "数据解析出错，请稍后重试！");	
			errorString="Volley Error: "+"数据解析出错，请稍后重试！";
		} else {
			Log.d("Volley Error: ", "数据解析出错，请稍后重试！");
			errorString="Volley Error: "+ "数据解析出错，请稍后重试！";
		}
		return errorString;
    	
    }
}
