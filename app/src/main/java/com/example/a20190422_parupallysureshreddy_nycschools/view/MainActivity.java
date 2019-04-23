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
import com.example.a20190422_parupallysureshreddy_nycschools.viewmodel.SchoolViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //getting recyclerview
    private RecyclerView recyclerView;

    //the Adapter
    SchoolAdapter schoolAdapter;

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
                schoolAdapter = new SchoolAdapter(MainActivity.this, schools);
                recyclerView.setAdapter(schoolAdapter);
                schoolAdapter.setOnItemClickListner(new SchoolAdapter.onItemClickListner() {
                    @Override
                    public void onClick(String str) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("School_name", str);
                        startActivityForResult(intent, 1);
                    }
                });
            }
        });

    }
}
