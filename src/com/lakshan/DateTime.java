package com.lakshan;

/**
 * Created by Lakshan on 9/15/17.
 */

//Class DateTime
public class DateTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minutes;

    //Constructor
    public DateTime(int year, int month, int day, int hour, int minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
    }

    //Getter for year
    public int getYear() {
        return year;
    }

    //Getter for month
    public int getMonth() {
        return month;
    }

    //Getter for day
    public int getDay() {
        return day;
    }

    //Getter for hour
    public int getHour() {
        return hour;
    }

    //Getter for minuters
    public int getMinutes() {
        return minutes;
    }

    //This will return date as a String
    public String getDate() {
        return year + "." + month + "." + day;
    }

    //This will return time as a String
    public String getTime() {
        return hour + ":" + minutes;
    }

}
