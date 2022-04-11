package com.example.myapp2021.comments;

import com.example.myapp2021.webservice.WebserviceCaller;

import java.util.HashMap;
import java.util.Objects;

public class CommentInteractor {

    WebserviceCaller webserviceCaller;

    public CommentInteractor(){
        webserviceCaller=new WebserviceCaller();
    }

    public void getComment(HashMap<String,Object> comment,ComListener listener){

        String name= Objects.requireNonNull(comment.get("name")).toString();
        if (name.isEmpty()){
            listener.onFailure("شما عضو نیستید");
        }

        String family= Objects.requireNonNull(comment.get("family")).toString();
        if (family.isEmpty()){
            listener.onFailure("شما عضو نیستید");
        }

        String Usercomment= Objects.requireNonNull(comment.get("comment")).toString();
        if (Usercomment.isEmpty()){
            listener.onEmptyComment("متن نظر شما خالی است");
        }


        webserviceCaller.getComemnt(comment, new ComListener() {

            @Override
            public void onSuccess(String responseMessage) {
                listener.onSuccess(responseMessage);
            }

            @Override
            public void onFailure(String errorResponseMessage) {
               listener.onFailure(errorResponseMessage);
            }

            @Override
            public void onEmptyComment(String errorResponseMessage) {

            }
        });
    }

}
