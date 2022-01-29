package com.example.myapp2021.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit=null;
    public static final String BaseURL="https://myapp2021.com/rest/";

    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BaseURL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
