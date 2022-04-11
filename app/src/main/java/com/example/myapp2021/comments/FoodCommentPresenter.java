package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

import java.util.List;

public class FoodCommentPresenter implements FoodCommentListener {
    @Override
    public void onSuccess(List<Comment> responseMessage) {

    }

    @Override
    public void onFailure(String errorResponseMessage) {

    }

    @Override
    public void onEmptyComment(String errorResponseMessage) {

    }
}
