package com.example.myapp2021.model;

public interface IMessageListner<T>{

    void onSuccess(T responseMessage);
    void onFailure(String errorResponseMessage);

}
