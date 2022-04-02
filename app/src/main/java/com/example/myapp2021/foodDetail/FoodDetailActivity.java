package com.example.myapp2021.foodDetail;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapp2021.R;
import com.example.myapp2021.Registration.LoginActivity;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.config.SharedPref;
import com.example.myapp2021.database.AppDatabase;
import com.example.myapp2021.databinding.ActivityFooddetailBinding;
import com.example.myapp2021.model.MFoods;

public class FoodDetailActivity extends AppCompatActivity {

    ActivityFooddetailBinding binding;
    Bundle bundle;
    MFoods foods;
    AppDatabase appDatabase;
    SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFooddetailBinding.inflate(getLayoutInflater());
        appDatabase = AppDatabase.getInstance(AppConfiguration.getContext());
        sharedPref=new SharedPref(AppConfiguration.getContext());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        foods = bundle.getParcelable("food");

        binding.txtFoodname.setText(foods.getName());
        binding.txtIngredients.setText(foods.getIngredients());
        binding.txtPrepare.setText(foods.getPrepare());

        assert binding.txtIfMember != null;
        binding.txtIfMember.setOnClickListener(v -> {
            Intent intent=new Intent(AppConfiguration.getContext(), LoginActivity.class);
            startActivity(intent);
        });




        Glide.with(binding.imgMainfood.getContext())
                .load(foods.getImageAddress())
                .apply(new RequestOptions())
                .into(binding.imgMainfood);

        binding.imgShare.setOnClickListener(v -> {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String body = foods.getPrepare();
            String sub = foods.getName();
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
            myIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(myIntent, "Share Using"));
        });
        likeFood();
    }



    private void likeFood() {
        boolean fav = appDatabase.iDao().isExist(Integer.parseInt(foods.getId()));
        if (fav) {
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
        } else {
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }

        binding.imgFavorite.setOnClickListener(v -> {
            boolean fav1 = appDatabase.iDao().isExist(Integer.parseInt(foods.getId()));

            if (fav1) {
                appDatabase.iDao().deleteById(Integer.parseInt(foods.getId()));
                binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);


            } else {
                appDatabase.iDao().insert(foods);
                binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
            }
        });
    }


}
