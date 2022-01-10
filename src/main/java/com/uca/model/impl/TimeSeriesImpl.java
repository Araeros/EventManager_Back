package com.uca.model.impl;

import com.uca.model.TimeSeries;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TimeSeriesImpl extends TimeSeries {

    private ArrayList<EventImpl> eventsList;

    public TimeSeriesImpl (String title, String description) {
        this.setSeriesId(this.genSeriesId(title, description));
        this.setTitle(title);
        this.setDescription(description);
        this.setEventsList();
    }

    public TimeSeriesImpl() {
        //TODO : Default Constructor
    }

    public static TimeSeriesImpl addSeries(TimeSeries timeSeries, UserImpl user) {
        //TODO: Add Series method
        //Cast TimeSeries to TimeSeriesImpl
        return new TimeSeriesImpl();
    }

    public void setEventsList(ArrayList<EventImpl> newEventsList) {
        this.eventsList = newEventsList;
    }

    public void setEventsList() {
        this.eventsList = new ArrayList<EventImpl>();
    }

    private String genSeriesId(String title, String description) {
        StringBuilder builder = new StringBuilder()
                .append(title.toLowerCase(Locale.ROOT).substring(0,1))
                .append("-")
                .append(description.toLowerCase(Locale.ROOT).substring(0,1))
                .append("-")
                .append(new Date());
        return builder.toString();
    }
}
