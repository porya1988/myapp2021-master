package com.example.myapp2021.webservice;

import android.util.Log;

import com.example.myapp2021.main.home.FoodAdapter;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.IMessageListner;
import com.example.myapp2021.model.MFoods;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    FService fservice = null;
    Food food;


    public WebserviceCaller() {
        fservice = ApiClient.getClient().create(FService.class);
    }

    public void getCategory(IMessageListner listner) {

        fservice.getCategory().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                listner.onSuccess(response.body());
                Log.e("", "");

            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

                Log.e("", "");

            }
        });
    }

    public void getAllfoods(String category, IMessageListner listner) {
        fservice.getAllfoods(category).enqueue(new Callback<List<MFoods>>() {
            @Override
            public void onResponse(Call<List<MFoods>> call, Response<List<MFoods>> response) {
                List<MFoods> mFoods=response.body();
                listner.onSuccess(mFoods);

            }

            @Override
            public void onFailure(Call<List<MFoods>> call, Throwable t) {
                listner.onFailure("Error");
            }
        });
    }
}