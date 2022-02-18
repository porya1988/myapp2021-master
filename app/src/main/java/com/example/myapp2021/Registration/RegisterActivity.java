package com.example.myapp2021.Registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapp2021.R;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.databinding.ActivityRegisterBinding;
import com.example.myapp2021.foodDetail.MembershipActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.HashMap;
import java.util.concurrent.Executor;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    private GoogleSignInClient googleSignInClient;
    private final static int RC_SIGN_IN = 123;

    com.example.myapp2021.Registration.handleSignInResult handleSignInResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnClose.setOnClickListener(v -> finish());

        binding.btnMembership.setOnClickListener(v -> {
            Intent intent = new Intent(AppConfiguration.getContext(), MembershipActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            AppConfiguration.getContext().startActivity(intent);
        });
       /* GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();*/



        binding.btnEnterGoogle.setOnClickListener(v -> {
            Intent signInIntent = googleSignInClient.getSignInIntent();
            //noinspection deprecation
            startActivityForResult(signInIntent, RC_SIGN_IN);
            Log.e("", "");

        });


        Log.e("", "");

        //Toast.makeText(AppConfiguration.getContext(),R.string.you_are_a_member,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            // Google Sign In was successful, authenticate with Firebase
            GoogleSignInAccount account = task.getResult();
            Log.e("", "");
            String IdToken = account.getIdToken();
            Log.e("", "");
            //handleSignInResult.firebaseAuthWithGoogle(IdToken);
            AuthCredential credential = GoogleAuthProvider.getCredential(IdToken, null);
            FirebaseAuth mAuth = FirebaseAuth.getInstance();

            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                //Toast.makeText(AppConfiguration.getContext(), R.string.you_are_a_member+""+user.getDisplayName(), Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Log.e("", "signInWithCredential:success");
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(AppConfiguration.getContext(), R.string.login_failed, Toast.LENGTH_LONG).show();
                                Log.e("", "signInWithCredential:failure");


                            }
                        }
                    });

        }
        // Google Sign In failed, update UI appropriately
    }


}
