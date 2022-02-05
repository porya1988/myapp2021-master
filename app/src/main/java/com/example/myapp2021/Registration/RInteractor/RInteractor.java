package com.example.myapp2021.Registration.RInteractor;

import android.util.Log;
import android.widget.Toast;



import com.example.myapp2021.R;
import com.example.myapp2021.Registration.RegisterListner.RegisterListner;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.model.IMessageListner;

import com.example.myapp2021.webservice.WebserviceCaller;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;

public class RInteractor {

    //FirebaseAuth firebaseAuth;
    WebserviceCaller webserviceCaller;

    public RInteractor() {
        /*firebaseAuth = FirebaseAuth.getInstance();*/
        webserviceCaller=new WebserviceCaller();
    }

    public void getUser(HashMap<String, Object> user, RegisterListner listener) {

        String name = Objects.requireNonNull(user.get("name")).toString();
        String family = Objects.requireNonNull(user.get("family")).toString();
        String password = Objects.requireNonNull(user.get("password")).toString();
        String email = Objects.requireNonNull(user.get("email")).toString();

        if (name.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_your_name);
            listener.onNameError(error);
            Log.e("", "");
            return;
        }
        if (family.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_your_family);
            listener.onFamilyError(error);
            Log.e("", "");
            return;
        }
        if (password.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_password);
            listener.onPasswordError(error);
            Log.e("", "");
            return;
        }
        if (password.length() < 6) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.password_length);
            listener.onPasswordError(error);
            Log.e("", "");
            return;
        }
        if (email.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_email);
            listener.onEmailError(error);
            Log.e("", "");
            return;
        }

        webserviceCaller.getUser(user, new IMessageListner() {
            @Override
            public void onSuccess(Object responseMessage) {
                listener.onSuccess((String) responseMessage);
            }

            @Override
            public void onFailure(String errorResponseMessage) {
               listener.onFailure(errorResponseMessage);
            }
        });



        /*firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (!task.isSuccessful()) {
                FirebaseAuthException e = (FirebaseAuthException) task.getException();
                Log.e("LoginActivity", "Failed Registration", e);
                String sign_failed = AppConfiguration.getContext().getResources().getString(R.string.sign_failed);
                listener.onFailure(sign_failed);
                return;
            }


            if (task.isSuccessful()) {
                String member = AppConfiguration.getContext().getResources().getString(R.string.you_are_a_member);
                listener.onSuccess(member);
                FirebaseFirestore database = FirebaseFirestore.getInstance();
                String User_id = firebaseAuth.getUid();
                if (User_id != null) {
                    user.put("User_id", User_id);
                    Log.e("", "");
                    database.collection("users")
                            .add(user)
                            .addOnSuccessListener(documentReference -> {
                                Toast.makeText(AppConfiguration.getContext(), R.string.you_are_a_member, Toast.LENGTH_LONG).show();
                                Log.e("", "");

                            })
                            .addOnFailureListener(e -> Toast.makeText(AppConfiguration.getContext(), R.string.error_occured, Toast.LENGTH_LONG).show());
                }
            } else {
                String failed = AppConfiguration.getContext().getResources().getString(R.string.login_failed);
                listener.onFailure(failed);
            }
        });*/
    }

    /*public void LogUser(HashMap<String, Object> user, IMessageListner listener) {
        String password = Objects.requireNonNull(user.get("password")).toString();
        String email = Objects.requireNonNull(user.get("email")).toString();

        if (email.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_email);
            listener.onFailure(error);
        }

        if (password.isEmpty()) {
            String error = AppConfiguration.getContext().getResources().getString(R.string.enter_password);
            listener.onFailure(error);
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (!task.isSuccessful()) {
                String sign_failed = AppConfiguration.getContext().getResources().getString(R.string.sign_failed);
                listener.onFailure(sign_failed);
                Log.e("", "");
            }

            if (task.isSuccessful()) {
                String signed = AppConfiguration.getContext().getResources().getString(R.string.login_successful);
                listener.onSuccess(signed);
            }
        });

    }*/
}
