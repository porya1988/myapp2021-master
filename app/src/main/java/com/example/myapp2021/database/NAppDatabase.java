package com.example.myapp2021.database;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapp2021.model.MFoods;
import com.example.myapp2021.model.Note;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NAppDatabase extends RoomDatabase {

    public abstract NDao iDao();

    private static NAppDatabase instance=null;


    public static synchronized NAppDatabase getInstance(Context context){

        if(instance==null){
            instance=Room.databaseBuilder(context,NAppDatabase.class,"tbl_note")
                    .allowMainThreadQueries().build();

        }
        return instance;

    }
}
