package com.example.myapp2021.foodDetail;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.myapp2021.Registration.RPresentor.RPresentor;
import com.example.myapp2021.Registration.RView.RView;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ActivityMembershipBinding;

import java.util.HashMap;
import java.util.Objects;

public class MembershipActivity extends AppCompatActivity implements RView {


    ActivityMembershipBinding binding;
    RPresentor presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMembershipBinding.inflate(getLayoutInflater());
        presenter = new RPresentor(this);
        setContentView(binding.getRoot());

        binding.imgBack.setOnClickListener(v -> finish());

        binding.createAccount.setOnClickListener(v -> {
            binding.registerProgressbar.setVisibility(View.VISIBLE);
            HashMap<String, Object> user = new HashMap<>();
            String name = Objects.requireNonNull(binding.name.getText()).toString();
            String family = Objects.requireNonNull(binding.family.getText()).toString();
            String password = Objects.requireNonNull(binding.password.getText()).toString();
            String email = Objects.requireNonNull(binding.emailEdittext.getText()).toString();
            user.put("name", name);
            user.put("family", family);
            user.put("password", password);
            user.put("email", email);
            Log.e("", "");
            presenter.getUser(user);
        });
    }


    @Override
    public void onNameError(String errorResponseMessage) {
        Toast.makeText(AppConfiguration.getContext(), "" + errorResponseMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFamilyError(String errorResponseMessage) {
        Toast.makeText(AppConfiguration.getContext(), "" + errorResponseMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void ShowProgressbar() {
        binding.registerProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideProgressbar() {
        binding.registerProgressbar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(String responseMessage) {
        Toast.makeText(AppConfiguration.getContext(), "" + responseMessage, Toast.LENGTH_LONG).show();
        Log.e("","");
    }

    @Override
    public void onError(String errorResponseMessage) {
        Toast.makeText(AppConfiguration.getContext(), "" + errorResponseMessage, Toast.LENGTH_LONG).show();
    }
}