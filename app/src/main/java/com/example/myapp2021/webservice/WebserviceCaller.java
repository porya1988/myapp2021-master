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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    FService fservice;

    public WebserviceCaller() {
        fservice = ApiClient.getClient().create(FService.class);
    }

    public void getCategory(IMessageListner listner) {
        fservice.getCategory().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(@NonNull Call<List<Food>> call, @NonNull Response<List<Food>> response) {
                listner.onSuccess(response.body());
                Log.e("","");
             }

            @Override
            public void onFailure(@NotNull Call<List<Food>> call, @NotNull Throwable t) {
                listner.onFailure("error");

            }
        });
    }

    public void getAllfoods(String category, IMessageListner listner) {
        fservice.getAllfoods(category).enqueue(new Callback<List<MFoods>>() {
            @Override
            public void onResponse(@NotNull Call<List<MFoods>> call, @NotNull Response<List<MFoods>> response) {
                List<MFoods> mFoods=response.body();
                listner.onSuccess(mFoods);

            }

            @Override
            public void onFailure(@NotNull Call<List<MFoods>> call, @NotNull Throwable t) {
                listner.onFailure("Error");
            }
        });
    }

    public void getUser(HashMap<String,Object> user,IMessageListner listner){
        String name= Objects.requireNonNull(user.get("name")).toString();
        String family= Objects.requireNonNull(user.get("family")).toString();
        String password= Objects.requireNonNull(user.get("password")).toString();
        String email= Objects.requireNonNull(user.get("email")).toString();
        Log.e("","");
        fservice.getUser(name,family,password,email).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                listner.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                listner.onFailure("error");
                Log.e("","");
            }
        });
}
}