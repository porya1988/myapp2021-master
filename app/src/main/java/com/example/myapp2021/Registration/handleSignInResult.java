package com.example.myapp2021.Registration;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.concurrent.Executor;

public class handleSignInResult {

    FirebaseAuth mAuth;
    String IdToken;
    public handleSignInResult(String IdToken) {
        this.IdToken = IdToken;
    }
    public void firebaseAuthWithGoogle(String IdToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(IdToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.e("", "signInWithCredential:success");
                        } else {
                            Toast.makeText(AppConfiguration.getContext(), R.string.login_failed, Toast.LENGTH_LONG).show();
                            Log.e("", "signInWithCredential:failure");
                        }
                    }
                });
    }
}
