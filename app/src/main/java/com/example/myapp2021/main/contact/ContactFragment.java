package com.example.myapp2021.main.contact;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapp2021.databinding.FragmentContactBinding;


public class ContactFragment extends Fragment {

    FragmentContactBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentContactBinding.inflate(getLayoutInflater());


        //binding.txtIfMember.setOnClickListener(v -> {
           // Intent intent = new Intent(AppConfiguration.getContext(), LoginActivity.class);
            //startActivity(intent);
        //});

        //Toast.makeText(AppConfiguration.getContext(),name+"نظرتو اینجا بنویس",Toast.LENGTH_LONG).show();
        return binding.getRoot();

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}