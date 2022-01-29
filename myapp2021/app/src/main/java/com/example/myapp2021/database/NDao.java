package com.example.myapp2021.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.myapp2021.model.Note;

import java.util.List;

@Dao
public interface NDao {

    @Insert
    long insert(Note note);

    @Query("delete from tbl_note where noteId=:noteId")
    void delete(int noteId);

    @Update
    void update(Note note);

    @Query("select * from tbl_note")
    List<Note> getNoteList();

}
