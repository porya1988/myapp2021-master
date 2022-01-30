package com.example.myapp2021.config;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

public class AppConfiguration extends Application {

    public  AppConfiguration instance=null;
    @SuppressLint("StaticFieldLeak")
    private static Context context;


    public static Context getContext(){return context;}

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());
        instance=this;
        context=getApplicationContext();
    }


}
