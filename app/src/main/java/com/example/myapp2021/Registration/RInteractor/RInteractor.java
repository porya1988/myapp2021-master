package com.example.myapp2021.Registration.RInteractor;

import android.util.Log;
import com.example.myapp2021.R;
import com.example.myapp2021.Registration.RegisterListner.RegisterListner;
import com.example.myapp2021.config.AppConfiguration;
import com.example.myapp2021.model.IMessageListner;
import com.example.myapp2021.webservice.WebserviceCaller;
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
        Log.e("","");
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
                listener.onSuccess(responseMessage.toString());
            }

            @Override
            public void onFailure(String errorResponseMessage) {
             listener.onFailure(errorResponseMessage);
            }
        });
    }

    public void LogUser(HashMap<String,Object> user,IMessageListner listner){
      /*  String email = Objects.requireNonNull(user.get("email")).toString();
        String password = Objects.requireNonNull(user.get("password")).toString();*/

        webserviceCaller.LogUser(user, new IMessageListner() {
            @Override
            public void onSuccess(Object responseMessage) {
                listner.onSuccess(responseMessage);
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                listner.onFailure(errorResponseMessage);
            }
        });


    }
}
