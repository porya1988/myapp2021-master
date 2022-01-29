package com.example.myapp2021.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapp2021.Registration.RPresentor.LogPresenter;
import com.example.myapp2021.Registration.RPresentor.RPresentor;
import com.example.myapp2021.Registration.RView.LogView;
import com.example.myapp2021.Registration.RView.RView;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ActivityLoginBinding;
import com.example.myapp2021.foodDetail.MembershipActivity;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements LogView {

    ActivityLoginBinding binding;
    LogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        presenter = new LogPresenter(this);
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> user = new HashMap<>();
                String email = binding.editEmail.getText().toString();
                String password = binding.editPassword.getText().toString();
                user.put("email", email);
                user.put("password", password);
                presenter.LogUser(user);

            }
        });

        binding.ifNotRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppConfiguration.getContext(), MembershipActivity.class);
                startActivity(intent);
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onSuccess(Object responseMessage) {
        Toast.makeText(AppConfiguration.getContext(), "" + responseMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void ShowProgressbar() {
        binding.progresbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideProgressbar() {
        binding.progresbar.setVisibility(View.GONE);
    }

    @Override
    public void onEmailPasswordError(Object emailErrorMessage) {
        Toast.makeText(AppConfiguration.getContext(), "" + emailErrorMessage, Toast.LENGTH_LONG).show();
    }
}