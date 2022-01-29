package com.example.myapp2021.foodDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapp2021.R;
import com.example.myapp2021.databinding.ActivityMembershipBinding;

public class MembershipActivity extends AppCompatActivity {


    ActivityMembershipBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMembershipBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}