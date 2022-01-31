package com.example.myapp2021.Registration.RView;

public interface LogView<T> {

    void onSuccess(T responseMessage);

    void ShowProgressbar();

    void HideProgressbar();

    void onEmailPasswordError(T emailErrorMessage);


}
