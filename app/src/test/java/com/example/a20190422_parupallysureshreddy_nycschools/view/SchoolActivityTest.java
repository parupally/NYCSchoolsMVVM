package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.view.View;

import com.example.a20190422_parupallysureshreddy_nycschools.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SchoolActivityTest {
    private SchoolActivity activity;
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        activity = new SchoolActivity();
    }

    @Test
    public void test_ActivityIsInitialized() {
        Assert.assertNotNull(activity);
    }
    @Test
    public void checkActivityNotNull() {
        assertNotNull("How come SplashActivity is null???", this.activity);
    }

}

