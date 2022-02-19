package com.example.myapp2021.Registration.RPresentor;

import com.example.myapp2021.Registration.RInteractor.RInteractor;
import com.example.myapp2021.Registration.RView.LogView;
import com.example.myapp2021.model.IMessageListner;

import java.util.HashMap;

public class LogPresenter implements IMessageListner {

    LogView logView;
    RInteractor interactor;

    public LogPresenter(LogView logView) {
        this.logView = logView;
        interactor = new RInteractor();
    }

    public void LogUser(HashMap<String, Object> user) {
        logView.ShowProgressbar();
        interactor.LogUser(user, this);
    }

    @Override
    public void onSuccess(Object responseMessage) {
        if (logView != null) {
            logView.onSuccess(responseMessage);
            logView.HideProgressbar();

        }
    }

    @Override
    public void onFailure(String errorResponseMessage) {
        logView.HideProgressbar();
        logView.onEmailPasswordError(errorResponseMessage);
    }
}
