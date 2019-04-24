package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.widget.TextView;

import com.example.a20190422_parupallysureshreddy_nycschools.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class SchoolDetailsActivityTest {
    private SchoolDetailsActivity activity;

     private TextView tvWriting;
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setup() {

        activity = new SchoolDetailsActivity();
         tvWriting = (TextView)activity.findViewById(R.id.tv_Writing);
    }

}