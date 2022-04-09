package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

import java.util.List;

public interface CommentView{

    void onSuccess(List<Comment> responseMessage);
    void onEmptyComment(String responseMessage);
    void onError(String errorResponseMessage);
    void ShowProgressbar();
    void hideProgressbar();


}
