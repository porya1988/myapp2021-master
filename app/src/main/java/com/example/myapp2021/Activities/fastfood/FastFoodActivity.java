package com.example.myapp2021.Activities.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapp2021.databinding.ActivityFastFoodBinding;
import com.example.myapp2021.main.home.HomePresenter;
import com.example.myapp2021.main.home.IHomeView;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.MFoods;

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

     binding.imgBack.setOnClickListener(v -> finish());
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
        Log.e("","");
        adapter = new FastFoodAdapter((List<MFoods>) responseMessage);
        binding.relCategory.setAdapter(adapter);
        binding.relCategory.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        Log.e("","");
    }

    @Override
    public void onFailure(String errorResponseMessage) {

    }

}