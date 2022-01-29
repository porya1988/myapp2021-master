package com.example.myapp2021.Activities.fastfood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ActivityFastFoodBinding;
import com.example.myapp2021.main.home.FoodAdapter;
import com.example.myapp2021.main.home.HomePresenter;
import com.example.myapp2021.main.home.IHomeView;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.MFoods;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FastFoodActivity extends AppCompatActivity implements IHomeView {

    ActivityFastFoodBinding binding;
    //fastfoodViewModel viewModel;
    Bundle bundle;
    Food food;
    HomePresenter presenter;
    FastFoodAdapter adapter;
    String stringCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_list);
        binding= ActivityFastFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot() );

        bundle = getIntent().getExtras();
        food = bundle.getParcelable("foodCategory");
        binding.txtFastfood.setText(food.getCategory());


        stringCategory = food.getCategory();

        presenter = new HomePresenter(this);
        presenter.getAllfoods(stringCategory);

        Log.e("", "");

     binding.imgBack.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });
    }

    @Override
    public void showProgressbar() {
        binding.progresbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressbar() {

        binding.progresbar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object responseMessage) {

        adapter = new FastFoodAdapter((List<MFoods>) responseMessage);
        binding.relCategory.setAdapter(adapter);
        binding.relCategory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    @Override
    public void onFailure(String errorResponseMessage) {

    }

    @Override
    public void onError(String error) {

    }

}