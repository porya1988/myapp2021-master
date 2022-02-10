package com.example.myapp2021.main.home;

public interface IHomeView<T> {
    void showProgressbar();
    void hideProgressbar();
    void onSuccess(T responseMessage);
    void onFailure(String errorResponseMessage);
}
