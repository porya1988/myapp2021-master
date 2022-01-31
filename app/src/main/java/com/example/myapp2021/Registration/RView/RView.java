package com.example.myapp2021.Registration.RView;

public interface RView<T> {
    void onNameError(T errorResponseMessage);

    void onFamilyError(T errorResponseMessage);

    void ShowProgressbar();

    void HideProgressbar();

    void onSuccess(T responseMessage);

    void onError(T errorResponseMessage);


}
