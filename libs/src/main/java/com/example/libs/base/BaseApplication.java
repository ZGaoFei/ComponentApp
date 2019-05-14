package com.example.libs.base;

import java.util.List;

import android.app.Application;
import android.util.Log;

import com.example.libs.utils.Utils;

public class BaseApplication extends Application {
    public static final String ROOT_PACKAGE = "com.example";

    private static BaseApplication mApp;

    private List<IApplicationDelegate> mDelegates;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        Utils.init(this);

        mDelegates = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, ROOT_PACKAGE);
        Log.e("zgf", "=======" + mDelegates.size());
        for (IApplicationDelegate delegate : mDelegates) {
            delegate.onCreate();
        }
    }

    public static BaseApplication getInstance() {
        return mApp;
    }

}
