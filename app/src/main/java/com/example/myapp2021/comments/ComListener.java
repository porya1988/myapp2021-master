package com.example.myapp2021.comments;

public interface ComListener {

    void onSuccess(String responseMessage);
    void onFailure(String errorResponseMessage);

    void onEmptyComment(String errorResponseMessage);
}
