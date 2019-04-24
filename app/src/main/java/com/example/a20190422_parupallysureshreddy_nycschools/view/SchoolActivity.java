package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a20190422_parupallysureshreddy_nycschools.R;
import com.example.a20190422_parupallysureshreddy_nycschools.model.School;
import com.example.a20190422_parupallysureshreddy_nycschools.onItemClickListner;
import com.example.a20190422_parupallysureshreddy_nycschools.viewmodel.SchoolViewModel;

import java.util.List;

import static com.example.a20190422_parupallysureshreddy_nycschools.Constants.SCHOOL_NAME;

public class SchoolActivity extends AppCompatActivity implements onItemClickListner {

    //getting recyclerview
    private RecyclerView recyclerView;

    //the Adapter
    private SchoolAdapter schoolAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up recyclerview
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        SchoolViewModel schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel.class);

        schoolViewModel.getSchools().observe(this, new Observer<List<School>>() {
            @Override
            public void onChanged(@Nullable List<School> schools) {
                schoolAdapter = new SchoolAdapter(schools);
                recyclerView.setAdapter(schoolAdapter);
                schoolAdapter.setOnItemClickListner(SchoolActivity.this);
            }
        });

    }


    @Override
    public void onClick(String School_Name) {
        Intent intent = new Intent(SchoolActivity.this, SchoolDetailsActivity.class);
        intent.putExtra(SCHOOL_NAME, School_Name);
        startActivity(intent);
    }
}
