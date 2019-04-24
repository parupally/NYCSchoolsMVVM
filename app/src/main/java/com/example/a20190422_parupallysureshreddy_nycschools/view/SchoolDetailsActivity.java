package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.a20190422_parupallysureshreddy_nycschools.R;
import com.example.a20190422_parupallysureshreddy_nycschools.model.Marks;
import com.example.a20190422_parupallysureshreddy_nycschools.viewmodel.MarksViewModel;

import java.util.List;

import static com.example.a20190422_parupallysureshreddy_nycschools.Constants.SCHOOL_NAME;

public class SchoolDetailsActivity extends AppCompatActivity {
    private TextView reading, writing, math;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        reading = (TextView) findViewById(R.id.tv_Reading);
        math = (TextView) findViewById(R.id.tv_Math);
        writing = (TextView) findViewById(R.id.tv_Writing);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            result = extras.getString(SCHOOL_NAME);
        }
        MarksViewModel marksViewModel = ViewModelProviders.of(this).get(MarksViewModel.class);
        marksViewModel.getMarks().observe(this, new Observer<List<Marks>>() {
            @Override
            public void onChanged(@Nullable List<Marks> marks) {
                if (marks != null && result != null) {
                    for (Marks marks1 : marks) {
                        if (marks1.getSchool_name().equalsIgnoreCase(result)) {
                            reading.setText(marks1.getSat_critical_reading_avg_score());
                            math.setText(marks1.getSat_math_avg_score());
                            writing.setText(marks1.getSat_writing_avg_score());
                        }
                    }
                }
            }
        });

    }
}
