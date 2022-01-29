package com.example.myapp2021.Registration;

public interface DStoreListner<T> {

    public void onSuccess(T responseMessage);

    public void onFailure(T errorResponseMessage);
}
