package com.example.a20190422_parupallysureshreddy_nycschools;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance mInstance;
    private static final String BASE_URL = "https://data.cityofnewyork.us";
    private Retrofit retrofit;


    private RetrofitInstance() {
        retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized RetrofitInstance getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitInstance();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

}
