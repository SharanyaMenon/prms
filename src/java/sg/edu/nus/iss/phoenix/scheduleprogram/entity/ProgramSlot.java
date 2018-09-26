/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author shara
 */
public class ProgramSlot {

    private String name;
    private Time duration;
    private Date date;
    private Time  startTime;
    private Time  endTime;
    private String presenter;
    private String producer;

    public ProgramSlot(String name, Time typicalDuration, Date date, Time  startTime, String presenter, String producer) {
        this.name = name;
        this.duration = typicalDuration;
        this.date = date;
        this.startTime = startTime;
        this.presenter = presenter;
        this.producer = producer;
       
    }
   
    public ProgramSlot(Date date, Time startTime) {
        this.date = date;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "ProgramSlot{" + "name=" + name + ", duration=" + duration + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + ", presenter=" + presenter + ", producer=" + producer + '}';
    }

    public Time  getEndTime() {
        return endTime;
    }

    public void setEndTime(Time  endTime) {
        this.endTime = endTime;
    }
   

    public ProgramSlot() {

    }

    public ProgramSlot(String scheduleProgramName) {
        this.name = scheduleProgramName;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time  getStartTime() {
        return startTime;
    }

    public void setStartTime(Time  startTime) {
        this.startTime = startTime;
    }

}
