package com.example.myapp2021.comments;

public interface CommentView<T>{

    void onSuccess(T responseMessage);
    void onEmptyComment(String responseMessage);
    void onError(String errorResponseMessage);
    void ShowProgressbar();
    void hideProgressbar();


}
