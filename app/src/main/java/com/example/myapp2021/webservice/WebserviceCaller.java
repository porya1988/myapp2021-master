package com.example.myapp2021.webservice;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapp2021.model.Comment;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.IMessageListner;
import com.example.myapp2021.model.MFoods;
import com.example.myapp2021.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    FService fservice;
    User user;
    Comment comment;

    public WebserviceCaller() {
        fservice = ApiClient.getClient().create(FService.class);
    }

    public void getCategory(IMessageListner<List<Food>> listener) {
        fservice.getCategory().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(@NonNull Call<List<Food>> call, @NonNull Response<List<Food>> response) {
                listener.onSuccess(response.body());
                Log.e("", "");
            }

            @Override
            public void onFailure(@NotNull Call<List<Food>> call, @NotNull Throwable t) {
                listener.onFailure("error");

            }
        });
    }

    public void getAllfoods(String category, IMessageListner<List<MFoods>> listener) {
        fservice.getAllfoods(category).enqueue(new Callback<List<MFoods>>() {
            @Override
            public void onResponse(@NotNull Call<List<MFoods>> call, @NotNull Response<List<MFoods>> response) {
                List<MFoods> mFoods = response.body();
                listener.onSuccess(mFoods);
            }

            @Override
            public void onFailure(@NotNull Call<List<MFoods>> call, @NotNull Throwable t) {
                listener.onFailure("Error");
            }
        });
    }

    public void getUser(HashMap<String, Object> user, IMessageListner<String> listener) {
        String name = Objects.requireNonNull(user.get("name")).toString();
        String family = Objects.requireNonNull(user.get("family")).toString();
        String password = Objects.requireNonNull(user.get("password")).toString();
        String email = Objects.requireNonNull(user.get("email")).toString();
        Log.e("", "");
        fservice.getUser(name, family, password, email).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                listener.onSuccess(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                listener.onFailure("?????? ?????? ???????????? ???????? ????????!!");
            }
        });
    }

    public void LogUser(HashMap<String, Object> user, IMessageListner listener) {
        String password = Objects.requireNonNull(user.get("password")).toString();
        String email = Objects.requireNonNull(user.get("email")).toString();
        fservice.LogUser(email,password).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> user=response.body();
                listener.onSuccess(user);
                //String family=response.body().get(1).toString();
                //sharedPref.save(name,family);
                Log.e("","");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onFailure("???????? ???????????? ???????? ????????");
                Log.e("","");
            }
        });
    }

/*    public void getFoodComments(String name, FoodCommentListener listener){
        fservice.getFoodComment(name).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                listener.onSuccess(response.body());
                Log.e("","");
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                  listener.onFailure("?????????? ???? ???????? ??????");
            }
        });
    }*/

}