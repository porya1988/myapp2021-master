package com.example.myapp2021.main.OptionMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapp2021.R;
import com.example.myapp2021.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    ActivityContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}