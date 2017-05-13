package com.example.nguyenxuantruong.myproject.Time;

import java.util.Calendar;

/**
 * Created by nguyenxuantruong on 5/5/17.
 */

public class Day {

    private int date;
    private int month;
    private int year;


    public Day(){
        Calendar c = Calendar.getInstance();
        this.date = c.get(Calendar.DATE);
        this.month = c.get(Calendar.MONTH);
        this.year = c.get(Calendar.YEAR);
    }

    public StringBuilder today(){
        StringBuilder data;
        data = new StringBuilder().append(date).append("/").append(month+1).append("/").append(year);
        return data;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}