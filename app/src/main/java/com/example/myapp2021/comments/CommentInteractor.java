package com.example.myapp2021.comments;

import com.example.myapp2021.model.Comment;
import com.example.myapp2021.webservice.WebserviceCaller;

import java.util.HashMap;

public class CommentInteractor {

    WebserviceCaller webserviceCaller;

    public CommentInteractor(){
        webserviceCaller=new WebserviceCaller();
    }

    public void getComment(HashMap<String,Object> comment,ComListener listener){

        String name=comment.get("name").toString();
        if (name.isEmpty()){
            listener.onFailure("شما عضو نیستید");
        }

        String family=comment.get("family").toString();
        if (family.isEmpty()){
            listener.onFailure("شما عضو نیستید");
        }

        String Usercomment=comment.get("comment").toString();
        if (Usercomment.isEmpty()){
            listener.onEmptyComment("متن نظر شما خالی است");
        }


        webserviceCaller.getComemnt(comment, new ComListener() {
            @Override
            public void onSuccess(Comment responseMessage) {
                listener.onSuccess(responseMessage);
            }

            @Override
            public void onFailure(String errorResponseMessage) {
               listener.onFailure(errorResponseMessage);
            }

            @Override
            public void onEmptyComment(String errorResponseMessage) {
             listener.onEmptyComment(errorResponseMessage);
            }
        });
    }

}
