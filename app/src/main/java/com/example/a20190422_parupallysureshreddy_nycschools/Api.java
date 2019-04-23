package com.example.a20190422_parupallysureshreddy_nycschools;

import com.example.a20190422_parupallysureshreddy_nycschools.model.Marks;
import com.example.a20190422_parupallysureshreddy_nycschools.model.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/resource/s3k6-pzi2")
    Call<List<School>> getSchool();


    @GET("/resource/f9bf-2cp4")
    Call<List<Marks>> getMarks();
}
