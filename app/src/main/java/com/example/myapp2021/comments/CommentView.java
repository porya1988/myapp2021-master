package com.example.myapp2021.comments;

public interface CommentView{

    void onSuccess(String responseMessage);
    void onEmptyComment(String responseMessage);
    void onError(String errorResponseMessage);
    void ShowProgressbar();
    void hideProgressbar();


}
