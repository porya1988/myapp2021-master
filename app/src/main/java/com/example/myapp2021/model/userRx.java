package com.example.myapp2021.model;

public class userRx {
    int age;
    String name;

    public userRx(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getUer(userRx userRx){
        String name=userRx.getName();
        String age=userRx.getName();
    }


}
