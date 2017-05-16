package com.example.minhphuong1894.googlemapmarkertest.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.example.minhphuong1894.googlemapmarkertest.datatranfobject.VolleySingleton;

/**
 * Created by minhphuong1894 on 5/16/17.
 */

public class CustomApplication extends Application {
    private RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();
    }
    public RequestQueue getVolleyRequestQueue(){
        return requestQueue;
    }
}