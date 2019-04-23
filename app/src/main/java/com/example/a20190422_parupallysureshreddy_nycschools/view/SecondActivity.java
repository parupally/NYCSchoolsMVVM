package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20190422_parupallysureshreddy_nycschools.R;
import com.example.a20190422_parupallysureshreddy_nycschools.model.Marks;
import com.example.a20190422_parupallysureshreddy_nycschools.viewmodel.MarksViewModel;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private TextView reading, writing, math;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        reading = (TextView) findViewById(R.id.tv_Reading);
        math = (TextView) findViewById(R.id.tv_Math);
        writing = (TextView) findViewById(R.id.tv_Writing);

        Bundle extras = getIntent().getExtras();
        String value;
        if (extras != null) {
            result = extras.getString("School_name");
        }
        MarksViewModel marksViewModel = ViewModelProviders.of(this).get(MarksViewModel.class);
        marksViewModel.getMarks().observe(this, new Observer<List<Marks>>() {
            @Override
            public void onChanged(@Nullable List<Marks> marks) {
                if (marks != null && result != null) {
                    for (Marks marks1 : marks) {
                        if (marks1.getSchool_name().equalsIgnoreCase(result)) {
                            reading.setText(marks.get(0).getSat_critical_reading_avg_score());
                            math.setText(marks.get(0).getSat_math_avg_score());
                            writing.setText(marks.get(0).getSat_writing_avg_score());
                        } else {
                            Toast.makeText(SecondActivity.this, "No data Available ", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }
}
