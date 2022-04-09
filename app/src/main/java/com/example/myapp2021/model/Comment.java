package com.example.myapp2021.model;

public class Comment {

    private String name;
    private String family;
    private String comment;
    private String date;

    public  Comment(String name,String family,String comment,String date){
        this.setName(name);
        this.setFamily(family);
        this.setComment(comment);
        this.setDate(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
