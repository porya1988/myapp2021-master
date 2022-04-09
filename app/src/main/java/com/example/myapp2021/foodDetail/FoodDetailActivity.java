package com.example.myapp2021.foodDetail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapp2021.R;
import com.example.myapp2021.Registration.LoginActivity;
import com.example.myapp2021.comments.CommentPresenter;
import com.example.myapp2021.comments.CommentTime;
import com.example.myapp2021.comments.CommentView;
import com.example.myapp2021.comments.CommentsAdapter;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.config.SharedPref;
import com.example.myapp2021.database.AppDatabase;
import com.example.myapp2021.databinding.ActivityFooddetailBinding;
import com.example.myapp2021.model.Comment;
import com.example.myapp2021.model.MFoods;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FoodDetailActivity extends AppCompatActivity implements CommentView {

    ActivityFooddetailBinding binding;
    Bundle bundle;
    MFoods foods;
    AppDatabase appDatabase;
    SharedPref sharedPref;
    CommentPresenter commentPresenter;
    String name;
    String family;
    CommentTime commentTime;
    CommentsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFooddetailBinding.inflate(getLayoutInflater());
        appDatabase = AppDatabase.getInstance(AppConfiguration.getContext());
        sharedPref = new SharedPref(AppConfiguration.getContext());
        commentPresenter = new CommentPresenter(this);
        name = sharedPref.getName();
        family=sharedPref.getFamily();
        commentTime=new CommentTime();

        setContentView(binding.getRoot());
        ////////////////////////////////////////////////////////////////////
        assert binding.send != null;
        binding.send.setOnClickListener(v -> {

                String date=commentTime.getCurrentTime();
                assert binding.commentEdit != null;
                String commentText= Objects.requireNonNull(binding.commentEdit.getText()).toString();
                HashMap<String,Object> comment=new HashMap<>();
                comment.put("name",name);
                comment.put("family",family);
                comment.put("comment",commentText);
                comment.put("date",date);
                commentPresenter.getComment(comment);
                Log.e("","");

        });


        ////////////////////////////////////////////////////////////////////
        bundle = getIntent().getExtras();
        foods = bundle.getParcelable("food");
        binding.txtFoodname.setText(foods.getName());
        binding.txtIngredients.setText(foods.getIngredients());
        binding.txtPrepare.setText(foods.getPrepare());

        ////////////////////////////////////////////////////////////////////
        assert binding.txtIfMember != null;
        binding.txtIfMember.setOnClickListener(v -> {
            Intent intent = new Intent(AppConfiguration.getContext(), LoginActivity.class);
            startActivity(intent);
        });
        ////////////////////////////////////////////////////////////////////
        Glide.with(binding.imgMainfood.getContext())
                .load(foods.getImageAddress())
                .apply(new RequestOptions())
                .into(binding.imgMainfood);
        ////////////////////////////////////////////////////////////////////
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
        ////////////////////////////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////////

    @Override
    protected void onStart() {
        //String name = sharedPref.getName();
        Log.e("", "");
        if (!name.isEmpty()) {
            assert binding.txtIfMember != null;
            binding.txtIfMember.setVisibility(View.GONE);
        }
        super.onStart();
    }

    ////////////////////////////////////////////////////////////////////


    @Override
    public void onSuccess(List<Comment> responseMessage) {
        Toast.makeText(AppConfiguration.getContext(), R.string.comment_added, Toast.LENGTH_LONG).show();
        adapter=new CommentsAdapter(responseMessage);
        Log.e("","");
    }

    @Override
    public void onEmptyComment(String responseMessage) {
        Toast.makeText(AppConfiguration.getContext(), responseMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String errorResponseMessage) {
        Toast.makeText(AppConfiguration.getContext(), errorResponseMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void ShowProgressbar() {
        assert binding.progressBar != null;
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        assert binding.progressBar != null;
        binding.progressBar.setVisibility(View.GONE);
    }
}
