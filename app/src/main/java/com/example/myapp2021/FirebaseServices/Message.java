package com.example.myapp2021.FirebaseServices;

import java.util.Date;

public class Message {

    //sender name as string
    private String sender;

    //message text as string
    private String content;

    //message is received or sent
    private boolean isMe;

    //date of receiving message
    private Date date;

    //constructor
    public Message(String sender, String content, boolean isMe, Date date) {
        this.sender = sender;
        this.content = content;
        this.isMe = isMe;
        this.date = date;
    }



    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
