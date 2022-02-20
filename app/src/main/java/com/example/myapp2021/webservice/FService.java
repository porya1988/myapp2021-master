package com.example.myapp2021.webservice;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.MFoods;
import com.example.myapp2021.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
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

    @FormUrlEncoded
    @POST("register.php")
    Call<String> getUser(@Field("name") String name,@Field("family") String family,@Field("password") String password,@Field("email") String email);

    @FormUrlEncoded
    @POST("login.php")
    Call<List<User>> LogUser(@Field("email") String email, @Field("password") String password);
}
