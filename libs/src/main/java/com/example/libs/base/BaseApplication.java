package com.example.libs.base;

import android.app.Application;

import com.example.libs.utils.Utils;


public class BaseApplication extends Application {

    private static BaseApplication mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        Utils.init(this);
    }

    public static BaseApplication getInstance() {
        return mApp;
    }

}
