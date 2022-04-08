package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

import java.util.HashMap;

public class CommentPresenter implements ComListener {

    CommentView commentView;
    CommentInteractor commentInteractor;

    public CommentPresenter(CommentView view){
        this.commentView=view;
        commentInteractor=new CommentInteractor();
    }

    public void getComment(HashMap<String,Object> comment){
        commentView.ShowProgressbar();
        commentInteractor.getComment(comment,this);
        //commentInteractor.getComment(comment);
    }


    @Override
    public void onSuccess(Comment responseMessage) {
       if (commentView !=null){
           commentView.hideProgressbar();
           commentView.onSuccess(responseMessage);
       }
    }

    @Override
    public void onFailure(String errorResponseMessage) {
      commentView.hideProgressbar();
      commentView.onError(errorResponseMessage);
    }

    @Override
    public void onEmptyComment(String errorResponseMessage) {
        commentView.hideProgressbar();
        commentView.onEmptyComment(errorResponseMessage);
    }
}
