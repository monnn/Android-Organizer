package com.moni.myapplication;

import java.sql.Time;
import java.util.Date;

/**
 * Created by moni on 15-6-2.
 */
public class Task {

    String title;
    String description;
    int priority;
    Date date;
    int time;

    public Task(String title, String description, int priority, Date date, int time) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
