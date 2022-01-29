package com.example.myapp2021.main.shoppinglist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.database.NAppDatabase;
import com.example.myapp2021.databinding.FragmentShoppingBinding;
import com.example.myapp2021.model.Note;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ShoppingFragment extends Fragment {

    FragmentShoppingBinding binding;
    AlarmDialog alarmDialog;
    NAppDatabase appDatabase;

    //////////////////////////////////////////////////
    public ShoppingFragment() {
    }

    //////////////////////////////////////////////////
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentShoppingBinding.inflate(getLayoutInflater());
        appDatabase=NAppDatabase.getInstance(AppConfiguration.getContext());
        alarmDialog = new AlarmDialog(getActivity());
        binding.btnAddnote.setOnClickListener(v -> {
            alarmDialog.showAddAlarm(() -> Loading());
        });


        return binding.getRoot();
    }

    //////////////////////////////////////////////////
    @Override
    public void onResume() {
        super.onResume();
        Loading();
    }

    private void Loading() {
        List<Note> noteList=appDatabase.iDao().getNoteList();
            binding.recyclerShoppinglist.setAdapter(new Notelistadapter(noteList));
            binding.recyclerShoppinglist.setLayoutManager(new GridLayoutManager(AppConfiguration.getContext(),2,RecyclerView.VERTICAL,false));
    }

}
