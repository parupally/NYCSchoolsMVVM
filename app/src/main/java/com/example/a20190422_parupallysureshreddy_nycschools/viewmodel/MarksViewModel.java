package com.example.a20190422_parupallysureshreddy_nycschools.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.a20190422_parupallysureshreddy_nycschools.model.Marks;
import com.example.a20190422_parupallysureshreddy_nycschools.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarksViewModel extends ViewModel {

    private MutableLiveData<List<Marks>> marksList;

    //we will call this method to get the data
    public LiveData<List<Marks>> getMarks() {
        //if the list is null
        if (marksList == null) {
            marksList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadMarks();
        }

        //finally we will return the list
        return marksList;
    }

    private void loadMarks() {
        RetrofitInstance.getInstance().getApi().getMarks().enqueue(new Callback<List<Marks>>() {
            @Override
            public void onResponse(Call<List<Marks>> call, Response<List<Marks>> response) {
                marksList.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Marks>> call, Throwable t) {

            }
        });

    }
}
