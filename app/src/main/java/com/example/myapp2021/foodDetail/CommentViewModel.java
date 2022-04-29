package com.example.myapp2021.foodDetail;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp2021.webservice.ApiClient;
import com.example.myapp2021.webservice.FService;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentViewModel extends ViewModel {

    MutableLiveData<String> message = null;
    FService fService;

    public LiveData<String> getComment(HashMap<String, Object> comment) {
        if (message == null) {
            message = new MutableLiveData<>();
            registerComment(comment);
        }
        return message;
    }

    public void registerComment(HashMap<String, Object> comment) {
        String name = Objects.requireNonNull(comment.get("name")).toString();
        String family = Objects.requireNonNull(comment.get("family")).toString();
        String Usercomment = Objects.requireNonNull(comment.get("comment")).toString();
        String date = Objects.requireNonNull(comment.get("date")).toString();
        String FoodName = Objects.requireNonNull(comment.get("FoodName")).toString();

        fService = ApiClient.getClient().create(FService.class);
        fService.getComment(name, family, Usercomment, date, FoodName).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                assert response.body() != null;
                String responseMessage = response.body();
                message.setValue(responseMessage);
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
            }
        });

    }

}


