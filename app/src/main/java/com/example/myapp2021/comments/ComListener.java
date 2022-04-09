package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

import java.util.List;

public interface ComListener {

    void onSuccess(List<Comment> responseMessage);
    void onFailure(String errorResponseMessage);

    void onEmptyComment(String errorResponseMessage);
}
