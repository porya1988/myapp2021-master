package com.example.myapp2021.config;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public SharedPref(Context context){
        sharedPreferences=context.getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void save(String name,String family){
        editor.putString("name",name);
        editor.putString("family",family);
        editor.commit();
    }

    public String getName(){
        return sharedPreferences.getString("name","");
    }
   public String getFamily(){
     return sharedPreferences.getString("family","");
   }
}
