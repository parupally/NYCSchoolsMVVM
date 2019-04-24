package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.widget.TextView;

import com.example.a20190422_parupallysureshreddy_nycschools.R;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertNotNull;

@RunWith(JUnit4.class)
public class SchoolDetailsActivityTest {
    private SchoolDetailsActivity activity;

    private TextView tvWriting;
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        activity = new SchoolDetailsActivity();
    }

    @Test
    public void test_ActivityIsInitialized() {
        Assert.assertNotNull(activity);
    }

    @Test
    public void checkActivityNotNull() {
        assertNotNull("How is activity?", this.activity);
    }

    @After
    public void tearDown() {
        activity = null;
    }
}