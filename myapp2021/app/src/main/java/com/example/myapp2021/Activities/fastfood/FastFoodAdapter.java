package com.example.myapp2021.Activities.fastfood;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;


import com.example.myapp2021.databinding.FastfoodrowBinding;
import com.example.myapp2021.foodDetail.FoodDetailActivity;
import com.example.myapp2021.model.Food;
import com.example.myapp2021.model.MFoods;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class FastFoodAdapter extends RecyclerView.Adapter<FastFoodAdapter.FastFoodVH> {


    List<MFoods> foodList;
    LayoutInflater inflater;
    FastfoodrowBinding binding;
    MFoods food;



    public FastFoodAdapter(List<MFoods> foodList) {
        inflater = LayoutInflater.from(AppConfiguration.getContext());
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FastFoodVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fastfoodrow,parent,false);
        return new FastFoodVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FastFoodVH holder, int position) {
        MFoods food=foodList.get(position);
        binding.setMfoods(food);

        binding.foodCard.setOnClickListener(v -> {
            Intent intent=new Intent(AppConfiguration.getContext(), FoodDetailActivity.class);
            intent.putExtra("food",food);
            Log.e("","");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            AppConfiguration.getContext().startActivity(intent);
        });


    }


    @Override
    public int getItemCount() {

        return foodList.size();
    }

    public class FastFoodVH extends RecyclerView.ViewHolder {

        FastfoodrowBinding binding;

        public FastFoodVH( FastfoodrowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @BindingAdapter("foodImage")
    public static void loadImage(CircleImageView view, String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions())
                .into(view);
        Log.e("","");

    }



}
