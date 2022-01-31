package com.example.myapp2021.main.contact;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.example.myapp2021.Registration.LoginActivity;


import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.FragmentContactBinding;


public class ContactFragment extends Fragment {


    FragmentContactBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(getLayoutInflater());

        binding.txtIfMember.setOnClickListener(v -> {
            Intent intent = new Intent(AppConfiguration.getContext(), LoginActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();

    }

    @Override
    public void onStart() {
        super.onStart();

    }
}