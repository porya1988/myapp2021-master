package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

public class CommentPresenter implements ComListener {

    CommentView commentView;
    CommentInteractor commentInteractor;

    public CommentPresenter(CommentView view){
        this.commentView=view;
        commentInteractor=new CommentInteractor();
    }

    @Override
    public void onSuccess(Comment responseMessage) {

        if (commentView!=null){
            commentView.onSuccess(responseMessage);
            commentView.hideProgressbar();
        }

    }

    @Override
    public void onFailure(String errorResponseMessage) {
           commentView.hideProgressbar();
           commentView.onError(errorResponseMessage);
    }
}
