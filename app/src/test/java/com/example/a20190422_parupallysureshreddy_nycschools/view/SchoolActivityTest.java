package com.example.a20190422_parupallysureshreddy_nycschools.view;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.example.a20190422_parupallysureshreddy_nycschools.model.School;
import com.example.a20190422_parupallysureshreddy_nycschools.viewmodel.SchoolViewModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class SchoolActivityTest {
    private SchoolActivity activity;
    private SchoolViewModel schoolViewModel;
    private MutableLiveData<List<School>> schoolList;
    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        activity = new SchoolActivity();
        schoolViewModel = mock(SchoolViewModel.class);
        when(schoolViewModel.getSchools()).thenReturn(schoolList);
    }

    @Test
    public void test_ActivityIsInitialized() {
        Assert.assertNotNull(activity);
    }

    @Test
    public void checkActivityNotNull() {
        assertNotNull("How is activity?", this.activity);
    }

    @Test
    public void checkLiveData() {
        schoolList = new MutableLiveData<>();
        List<School> list = new ArrayList<>();
        School school = new School();
        list.add(school);
        schoolList.postValue(list);
        assertEquals(list, schoolList.getValue());
    }

    @Test
    public void checkLiveData_Size() {
        schoolList = new MutableLiveData<>();
        List<School> list = new ArrayList<>();
        School school = new School();
        school.setSchool_name("Health Opportunities High School");
        list.add(school);
        schoolList.postValue(list);
        assertEquals(1, schoolList.getValue().size());
    }

    @After
    public void tearDown() {
        activity = null;
    }
}

