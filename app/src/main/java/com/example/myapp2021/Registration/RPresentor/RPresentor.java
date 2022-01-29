package com.example.myapp2021.Registration.RPresentor;

import com.example.myapp2021.Registration.RInteractor.RInteractor;
import com.example.myapp2021.Registration.RView.RView;
import com.example.myapp2021.Registration.RegisterListner.RegisterListner;

import java.util.HashMap;

public class RPresentor implements RegisterListner {

    RView rView;
    RInteractor interactor;

    public RPresentor(RView rView) {
        this.rView = rView;
        interactor = new RInteractor();
    }


    public void getUser(HashMap<String, Object> user) {

        interactor.getUser(user, this);
    }


    @Override
    public void onSuccess(String responseMessage) {
        if (rView != null) {
            rView.HideProgressbar();
            rView.onSuccess(responseMessage);
        }

    }

    @Override
    public void onUsernameError(String usernameResponseMessage) {
        rView.HideProgressbar();
        rView.onError(usernameResponseMessage);
    }

    @Override
    public void onFailure(String errorResponseMessage) {
        rView.HideProgressbar();
        rView.onError(errorResponseMessage);

    }

    @Override
    public void onPasswordError(String passResponseMessage) {
        rView.HideProgressbar();
        rView.onError(passResponseMessage);
    }

    @Override
    public void onNameError(String nameResponseMessage) {
        rView.HideProgressbar();
        rView.onNameError(nameResponseMessage);
    }

    @Override
    public void onFamilyError(String famResponseMesaage) {
        rView.HideProgressbar();
        rView.onFamilyError(famResponseMesaage);
    }

    @Override
    public void onEmailError(String emailResponseMessage) {
        rView.HideProgressbar();
        rView.onError(emailResponseMessage);
    }


}
