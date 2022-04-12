package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;

import java.util.List;

public class AllCommentsPresenter implements FoodCommentListener{

    CommentView view;
    CommentInteractor interactor;
    public AllCommentsPresenter(CommentView view){
        this.view=view;
        interactor=new CommentInteractor();
    }

    public void getAllComments(String name){
        view.ShowProgressbar();
        interactor.getAllComments(name,this);
    }

    @Override
    public void onSuccess(List<Comment> responseMessage) {
        if (view !=null){
            view.hideProgressbar();
            view.onSuccess(responseMessage);
        }
    }

    @Override
    public void onFailure(String errorResponseMessage) {
        view.hideProgressbar();
        view.onError(errorResponseMessage);
    }

    @Override
    public void onEmptyComment(String errorResponseMessage) {
        view.hideProgressbar();
        view.onEmptyComment(errorResponseMessage);
    }
}
