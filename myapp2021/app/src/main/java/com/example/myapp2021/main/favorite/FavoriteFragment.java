package com.example.myapp2021.main.favorite;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp2021.Activities.fastfood.FastFoodAdapter;
import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.AppDatabase;
import com.example.myapp2021.databinding.FragmentFavoriteBinding;

import org.jetbrains.annotations.NotNull;


public class FavoriteFragment extends Fragment {


    FragmentFavoriteBinding binding;
    AppDatabase appDatabase;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_favorite, container, false);
        binding=FragmentFavoriteBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        appDatabase=AppDatabase.getInstance(AppConfiguration.getContext());
        binding.recyclerFavorites.setAdapter(new FastFoodAdapter(appDatabase.iDao().getFoodList()));
        binding.recyclerFavorites.setLayoutManager(new GridLayoutManager(AppConfiguration.getContext(),1));
    }
}