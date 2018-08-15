package com.example.android.quakereport;

public class QuakeItem {
    double quakeMagnitude;
    String quakeLocation1;
    String quakeLocation2;
    long quakeDate;
    String url;
    public QuakeItem(double quakeMagnitude, String quakeLocation1, String quakeLocation2, long quakeDate, String url){
        this.quakeMagnitude = quakeMagnitude;
        this.quakeLocation1 = quakeLocation1;
        this.quakeLocation2 = quakeLocation2;
        this.quakeDate = quakeDate;
        this.url = url;
    }

    public String getUrl(){
        return url;

    }

    public long getTimeInMs(){
        return quakeDate;
    }
    public double getMagnitude(){
        return quakeMagnitude;
    }
}
