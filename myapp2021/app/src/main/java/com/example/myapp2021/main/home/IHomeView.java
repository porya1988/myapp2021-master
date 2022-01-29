package com.example.myapp2021.main.home;

import com.example.myapp2021.model.Food;

import java.util.List;

public interface IHomeView<T> {
    public void showProgressbar();
    public void hideProgressbar();
    public void onSuccess(T responseMessage);
    public void onFailure(String errorResponseMessage);
    public void onError(String error);
}
