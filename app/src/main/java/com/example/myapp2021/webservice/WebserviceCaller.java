package com.example.myapp2021.webservice;

import android.util.Log;

import androidx.annotation.NonNull;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.IMessageListner;
import com.example.myapp2021.model.MFoods;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    FService fservice;

    public WebserviceCaller() {
        fservice = ApiClient.getClient().create(FService.class);
    }

    public void getCategory(IMessageListner listener) {
        fservice.getCategory().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(@NonNull Call<List<Food>> call, @NonNull Response<List<Food>> response) {
                listener.onSuccess(response.body());
                Log.e("","");
             }

            @Override
            public void onFailure(@NotNull Call<List<Food>> call, @NotNull Throwable t) {
                listener.onFailure("error");

            }
        });
    }

    public void getAllfoods(String category, IMessageListner listener) {
        fservice.getAllfoods(category).enqueue(new Callback<List<MFoods>>() {
            @Override
            public void onResponse(@NotNull Call<List<MFoods>> call, @NotNull Response<List<MFoods>> response) {
                List<MFoods> mFoods=response.body();
                listener.onSuccess(mFoods);

            }

            @Override
            public void onFailure(@NotNull Call<List<MFoods>> call, @NotNull Throwable t) {
                listener.onFailure("Error");
            }
        });
    }

    public void getUser(HashMap<String,Object> user,IMessageListner listener){
        String name= Objects.requireNonNull(user.get("name")).toString();
        String family= Objects.requireNonNull(user.get("family")).toString();
        String password= Objects.requireNonNull(user.get("password")).toString();
        String email= Objects.requireNonNull(user.get("email")).toString();
        Log.e("","");
        fservice.getUser(name,family,password,email).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                listener.onSuccess(response.body());
                Log.e("","");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
}
}