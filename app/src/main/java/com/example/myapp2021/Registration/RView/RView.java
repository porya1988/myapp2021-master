package com.example.myapp2021.Registration.RView;

public interface RView<T> {
    public void onNameError(T errorResponseMessage);

    public void onFamilyError(T errorResponseMessage);

    public void ShowProgressbar();

    public void HideProgressbar();

    public void onSuccess(T responseMessage);

    public void onError(T errorResponseMessage);


}
