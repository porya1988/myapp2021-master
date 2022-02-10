package com.example.myapp2021.Registration.RView;

public interface RView {
    void onNameError(String errorResponseMessage);

    void onFamilyError(String errorResponseMessage);

    void ShowProgressbar();

    void HideProgressbar();

    void onSuccess(String responseMessage);

    void onError(String errorResponseMessage);


}
