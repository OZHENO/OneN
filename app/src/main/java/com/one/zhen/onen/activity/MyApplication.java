package com.one.zhen.onen.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by 南尘 on 16-7-28.
 */
public class MyApplication extends Application {
    private static Context instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();
    }
    public static Context getAppContext()
    {
        return instance;
    }
}
