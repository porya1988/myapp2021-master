package com.example.myapp2021.config;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.multidex.MultiDex;

public class AppConfiguration extends Application {

    public  AppConfiguration instance=null;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public AppConfiguration(Context context){
        sharedPreferences=context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }


    public static Context getContext(){return context;}

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());
        instance=this;
        context=getApplicationContext();
    }

    public void save(String name,String family){
        editor.putString("name",name);
        editor.putString("family",family);
        editor.commit();
    }
}
