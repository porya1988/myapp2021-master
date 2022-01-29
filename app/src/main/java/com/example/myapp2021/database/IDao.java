package com.example.myapp2021.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapp2021.model.MFoods;

import java.util.List;

import retrofit2.http.DELETE;

@Dao
public interface IDao {

    @Insert
    long insert(MFoods foods);



    @Query("DELETE FROM tbl_food WHERE id = :id")
    void deleteById(int id);

    @Update
    void update(MFoods foods);

    @Query("select * from tbl_food")
    List<MFoods> getFoodList();

    @Query("select EXISTS(select * from tbl_food where id=:id)")
    boolean isExist(int id);

}
