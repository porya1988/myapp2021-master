package com.example.myapp2021.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.model.MFoods;
import com.example.myapp2021.model.Note;

@Database(entities = {MFoods.class},version = 1,exportSchema = false)

public  abstract class AppDatabase extends RoomDatabase {

    public abstract IDao iDao();

    private static AppDatabase instance=null;


    public static synchronized AppDatabase getInstance(Context context){

        if(instance==null){
            instance= Room.databaseBuilder(context,AppDatabase.class,"tbl_food").
                    allowMainThreadQueries().build();

        }
        return instance;

    }




}
