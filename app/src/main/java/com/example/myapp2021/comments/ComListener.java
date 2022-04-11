package com.example.myapp2021.comments;

public interface ComListener<T> {

    void onSuccess(T responseMessage);
    void onFailure(String errorResponseMessage);

    void onEmptyComment(String errorResponseMessage);
}
