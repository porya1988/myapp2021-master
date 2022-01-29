package com.example.myapp2021.Registration;

import android.util.Log;
import android.widget.Toast;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class GoogleSignIn {

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    GoogleSignInAccount account = com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount(AppConfiguration.getContext());

    public GoogleSignIn Googleuser = null;

    GoogleSignIn getUser() {
        if (Googleuser == null)
            Googleuser = new GoogleSignIn();
        return Googleuser;
    }

    public void getData() {

        HashMap<String, Object> data = new HashMap<>();
        String first_name = account.getGivenName();
        String last_name = account.getFamilyName();
        data.put("first_name", first_name);
        data.put("last_name", last_name);

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



