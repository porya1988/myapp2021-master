package com.example.myapp2021.comments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CommentTime {

    Calendar calendar;



    public CommentTime(){
        calendar=Calendar.getInstance();
    }
    public String getCurrentTime(){
        String date;
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
        date = dateFormat.format(calendar.getTime());
        return date;
    }


}
