package com.moni.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by moni on 15-6-3.
 */
public class MyApplication extends Application {

    private static Context mContext;

    public static Context getContext() {
        //  return instance.getApplicationContext();
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //  instance = this;
        mContext = getApplicationContext();
    }
}
