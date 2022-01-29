package com.example.myapp2021.Activities.fastfood;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp2021.databinding.ActivityFastFoodBinding;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.webservice.ApiClient;
import com.example.myapp2021.webservice.FService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fastfoodViewModel extends ViewModel {

    MutableLiveData<List<Food>> foodlist=null;

    public LiveData<List<Food>> getFastfood(){

        if (foodlist==null){
            foodlist=new MutableLiveData<>();
           loadData();
        }
        return foodlist;
    }

    public void loadData(){
        FService fService= ApiClient.getClient().create(FService.class);
        fService.getFastfood().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                foodlist.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });
    }

}
