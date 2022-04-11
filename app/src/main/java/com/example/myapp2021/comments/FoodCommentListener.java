package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

import java.util.List;

public interface FoodCommentListener {
    void onSuccess(List<Comment> responseMessage);
    void onFailure(String errorResponseMessage);

    void onEmptyComment(String errorResponseMessage);
}
