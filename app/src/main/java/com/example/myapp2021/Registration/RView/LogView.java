package com.example.myapp2021.Registration.RView;

public interface LogView<T> {

    public void onSuccess(T responseMessage);

    public void ShowProgressbar();

    public void HideProgressbar();

    public void onEmailPasswordError(T emailErrorMessage);


}
