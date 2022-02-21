package com.example.myapp2021.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapp2021.Registration.RPresentor.LogPresenter;
import com.example.myapp2021.Registration.RView.LogView;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ActivityLoginBinding;
import com.example.myapp2021.foodDetail.MembershipActivity;
import com.example.myapp2021.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements LogView {

    ActivityLoginBinding binding;
    LogPresenter presenter;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        presenter = new LogPresenter(this);
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {
            HashMap<String, Object> user = new HashMap<>();
            String email = Objects.requireNonNull(binding.editEmail.getText()).toString();
            String password = Objects.requireNonNull(binding.editPassword.getText()).toString();
            user.put("email", email);
            user.put("password", password);
            presenter.LogUser(user);

        });

        binding.ifNotRegistered.setOnClickListener(v -> {
            Intent intent = new Intent(AppConfiguration.getContext(), MembershipActivity.class);
            startActivity(intent);
        });

        binding.imgBack.setOnClickListener(v -> finish());

    }

    @Override
    public void onSuccess(Object responseMessage) {
        Log.e("","");
        //Toast.makeText(AppConfiguration.getContext(), "", Toast.LENGTH_LONG).show();
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