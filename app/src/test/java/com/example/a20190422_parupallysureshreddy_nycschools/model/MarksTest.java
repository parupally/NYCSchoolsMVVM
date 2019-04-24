package com.example.a20190422_parupallysureshreddy_nycschools.model;

import com.example.a20190422_parupallysureshreddy_nycschools.model.Marks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MarksTest {
     private Marks marks;

    @Before
    public void setup() {
        marks = new Marks();
    }

    @Test
    public void test_DBN() {

        marks.setDbn("123");
        Assert.assertEquals("123", marks.getDbn());
    }

    @Test
    public void test_Writing_Avg_score() {
        marks.setSat_writing_avg_score("12345");
        Assert.assertEquals("12345", marks.getSat_writing_avg_score());
    }

    @Test
    public void test_Num_Of_Sat_Test_Takers() {
        marks.setNum_of_sat_test_takers("12345");
        Assert.assertEquals("12345", marks.getNum_of_sat_test_takers());
    }

    @Test
    public void test_Match_AvgScore() {
        marks.setSat_math_avg_score("123456");
        Assert.assertEquals("123456", marks.getSat_math_avg_score());
    }

    @Test
    public void test_Sat_critical_reading_avg_score() {
        marks.setSat_critical_reading_avg_score("123456");
        Assert.assertEquals("123456", marks.getSat_critical_reading_avg_score());
    }

    @Test
    public void test_School_name() {
        marks.setSchool_name("Health Opportunities High School");
        Assert.assertEquals("Health Opportunities High School", marks.getSchool_name());
    }
}
