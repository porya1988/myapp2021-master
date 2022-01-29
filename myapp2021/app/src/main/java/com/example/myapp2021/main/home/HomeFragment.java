
package com.example.myapp2021.main.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.FragmentHomeBinding;
import com.example.myapp2021.model.Food;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class HomeFragment extends Fragment implements IHomeView {


    FragmentHomeBinding binding;
    HomePresenter presenter;
    FoodAdapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
       // View view = inflater.inflate(R.layout.fragment_home, container, false);
       // recyclerView = view.findViewById(R.id.recycler_categories);
        //progressBar = view.findViewById(R.id.progressBar);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new HomePresenter(this);
        presenter.getCategory();
        Log.e("", "");
    }


    @Override
    public void showProgressbar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object responseMessage) {
        Log.e("", "");
        adapter = new FoodAdapter(getActivity(), (List<Food>) responseMessage);
        binding.recyclerCategories.setAdapter(adapter);
        binding.recyclerCategories.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

    }

    @Override
    public void onFailure(String errorResponseMessage) {

    }

    @Override
    public void onError(String error) {

    }


}