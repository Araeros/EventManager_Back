package com.uca.model.impl;

import com.uca.model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EventImpl extends Event {

    private ArrayList<LabelImpl> labelList;

    public EventImpl (String value, Date date, String comment) {
        this.setEventId(this.genEventId(value, comment));
        this.setValue(value);
        this.setDate(date);
        this.setComment(comment);
        this.setEventsList();
    }

    public void setEventsList(ArrayList<LabelImpl> newLabelList) {
        this.labelList = newLabelList;
    }

    public void setEventsList() {
        this.labelList = new ArrayList<LabelImpl>();
    }

    private String genEventId(String value, String comment) {
        StringBuilder builder = new StringBuilder()
                .append(value.toLowerCase(Locale.ROOT).substring(0,1))
                .append("-")
                .append(comment.toLowerCase(Locale.ROOT).substring(0,1))
                .append("-")
                .append(new Date());
        return builder.toString();
    }

}
