package com.example.myapp2021.main.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp2021.Activities.fastfood.FastFoodActivity;
import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodVH> {

    List<Food> foodList;
    Context context;


    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        @SuppressLint("InflateParams") View view = LayoutInflater.from(context).inflate(R.layout.food_row, null);
        return new FoodVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodVH holder, int position) {

        Food food = foodList.get(position);
        holder.txt_title.setText(food.getCategory());


        Picasso.get().load(food.getImageAddress()).into(holder.img_food);

        holder.rel_foods.setOnClickListener(v -> {
            Log.e("", "");
            Intent intent = new Intent(context, FastFoodActivity.class);
            intent.putExtra("foodCategory", food);

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            AppConfiguration.getContext().startActivity(intent);


        });

    }

    @Override
    public int getItemCount() {

        return foodList.size();
    }


    public class FoodVH extends RecyclerView.ViewHolder {

        AppCompatTextView txt_title;
        AppCompatImageView img_food;
        LinearLayout rel_foods;
        //CardView card_categories;


        public FoodVH(View iteView) {
            super(iteView);
            //card_categories=iteView.findViewById(R.id.card_Categories);
            txt_title = iteView.findViewById(R.id.txt_title);
            img_food = iteView.findViewById(R.id.img_foodCat);
            rel_foods = iteView.findViewById(R.id.rel_foods);
        }
    }
}
