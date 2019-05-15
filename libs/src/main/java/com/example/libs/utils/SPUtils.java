package com.example.libs.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.libs.base.BaseApplication;

public class SPUtils {
    private static SPUtils spUtils;

    private static final String SP_NAME = "component_app";
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";

    private SharedPreferences sharedPreferences;


    private SPUtils() {
        sharedPreferences = BaseApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static SPUtils instance() {
        if (spUtils == null) {
            spUtils = new SPUtils();
        }
        return spUtils;
    }

    public void putString(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            sharedPreferences.edit().putString(key, value).apply();
        }
    }

    public String getString(String key) {
        if (TextUtils.isEmpty(key)) {
            return "";
        }
        return sharedPreferences.getString(key, "");
    }

}
