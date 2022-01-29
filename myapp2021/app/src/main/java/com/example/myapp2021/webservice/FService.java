package com.example.myapp2021.webservice;

import android.util.Log;

import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.MFoods;
import com.rd.animation.data.Value;

import java.lang.annotation.Target;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FService {

    @GET("getCategories.php")
    Call<List<Food>> getCategory();

    @GET("getFastfood.php")
    Call<List<Food>> getFastfood();

    //be khater estefade az dastor @Field bayad az dastor @FormUrlEncoded estefade konim




    @GET("getAllfoods.php")
    Call<List<MFoods>> getAllfoods(@Query("category") String category);

















/*
    @GET("getCakes.php")
    Call<ResponseBody> getCakes();

    @GET("getFormalFood.php")
    Call<ResponseBody> getFormalfood();

    @GET("getHomefood.php")
    Call<ResponseBody> getHomefood();
*/

}
