package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

public interface ComListener {

    void onSuccess(Comment responseMessage);
    void onFailure(String errorResponseMessage);

    void onEmptyComment(String errorResponseMessage);
}
