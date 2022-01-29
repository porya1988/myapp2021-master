package com.example.myapp2021.Registration;

import android.util.Log;
import android.widget.Toast;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import javax.inject.Singleton;

public class addDatatoFirestore {

    public addDatatoFirestore() {
    }

    public void addDataToFireStore(HashMap<String, Object> data) {

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        Log.e("", "");
        database.collection("users")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(AppConfiguration.getContext(), R.string.you_are_a_member, Toast.LENGTH_LONG).show();
                    Log.e("", "");
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(AppConfiguration.getContext(), R.string.error_occured, Toast.LENGTH_LONG).show();
                });
        Log.e("", "");
    }


}
