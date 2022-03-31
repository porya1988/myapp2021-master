package com.example.myapp2021.main.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapp2021.Registration.LoginActivity;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.config.SharedPref;
import com.example.myapp2021.databinding.FragmentContactBinding;


public class ContactFragment extends Fragment {


    FragmentContactBinding binding;
    SharedPref sharedPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(getLayoutInflater());
        sharedPref=new SharedPref(AppConfiguration.getContext());
        binding.txtIfMember.setOnClickListener(v -> {
            Intent intent = new Intent(AppConfiguration.getContext(), LoginActivity.class);
            startActivity(intent);
        });
        String name=sharedPref.getName();
        String family=sharedPref.getFamily();
        //Toast.makeText(AppConfiguration.getContext(),name+"نظرتو اینجا بنویس",Toast.LENGTH_LONG).show();
        return binding.getRoot();

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}