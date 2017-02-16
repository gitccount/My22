/**
 * 
 */
package com.example.app;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapLruCache extends LruCache<String, Bitmap> implements
		ImageCache {

	/**
	 * @param maxSize
	 */
	public BitmapLruCache(int maxSize) {
		super(maxSize);
	}
	
	@Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

	@Override
	public Bitmap getBitmap(String url) {
		return (Bitmap)get(url);
	}

	@Override
	public void putBitmap(String key, Bitmap bitmap) {
		put(key, bitmap); 
	}

}
