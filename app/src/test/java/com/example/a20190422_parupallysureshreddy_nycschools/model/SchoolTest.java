package com.example.a20190422_parupallysureshreddy_nycschools.model;


import com.example.a20190422_parupallysureshreddy_nycschools.model.School;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SchoolTest {
    private School school;

    @Before
    public void setup() {
        school = new School();
    }

    @Test
    public void test_DBN() {

        school.setDbn("1234");
        Assert.assertEquals("1234", school.getDbn());
    }

    @Test
    public void test_City() {
        school.setCity("Chicago");
        Assert.assertEquals("Chicago", school.getCity());
    }

    @Test
    public void test_School_name() {
        school.setSchool_name("Health Opportunities High School");
        Assert.assertEquals("Health Opportunities High School", school.getSchool_name());
    }

    @Test
    public void test_Building_code() {
        school.setBuilding_code("12345");
        Assert.assertEquals("12345", school.getBuilding_code());
    }


}
