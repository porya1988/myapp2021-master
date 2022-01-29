package com.example.myapp2021.main.contact;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapp2021.R;
import com.example.myapp2021.Registration.LoginActivity;
import com.example.myapp2021.Registration.RegisterActivity;
import com.example.myapp2021.Registration.addDatatoFirestore;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.FragmentContactBinding;
import com.example.myapp2021.foodDetail.MembershipActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;


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