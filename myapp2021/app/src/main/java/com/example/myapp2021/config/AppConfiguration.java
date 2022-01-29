package com.example.myapp2021.config;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

public class AppConfiguration extends Application {

    public static AppConfiguration instance=null;
    private static Context context;

    AppConfiguration getInstance(){
      if(instance==null)
          instance=new AppConfiguration();
          return instance;
    }

    public static Context getContext(){return context;}

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(getApplicationContext());
        instance=this;
        context=getApplicationContext();
    }


}
