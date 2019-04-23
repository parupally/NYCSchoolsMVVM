package com.example.a20190422_parupallysureshreddy_nycschools.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.example.a20190422_parupallysureshreddy_nycschools.RetrofitInstance;
import com.example.a20190422_parupallysureshreddy_nycschools.model.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolViewModel extends ViewModel {
    private MutableLiveData<List<School>> schoolList;

    //we will call this method to get the data
    public LiveData<List<School>> getSchools() {
        //if the list is null
        if (schoolList == null) {
            schoolList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadSchools();
        }

        //finally we will return the list
        return schoolList;
    }

    private void loadSchools() {
        RetrofitInstance.getInstance().getApi().getSchool().enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schoolList.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {

            }
        });

    }
}
