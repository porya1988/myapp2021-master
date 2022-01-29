package com.example.myapp2021.model;

import java.util.List;

import okhttp3.ResponseBody;

public interface IMessageListner<T>{

    public void onSuccess(T responseMessage);
    public void onFailure(String errorResponseMessage);

}
