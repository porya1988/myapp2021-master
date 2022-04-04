package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

public interface CommentView{

    void onSuccess(Comment responseMessage);
    void onEmptyComment(String responseMessage);
    void onError(String errorResponseMessage);
    void ShowProgressbar();
    void hideProgressbar();


}
