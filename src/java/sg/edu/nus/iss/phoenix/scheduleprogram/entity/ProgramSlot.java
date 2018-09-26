/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author shara
 */
public class ProgramSlot {

    private String name;
    private Time duration;

    public ProgramSlot(String name, Time typicalDuration, Timestamp date, Timestamp  startTime, String presenter, String producer) {
        this.name = name;
        this.duration = typicalDuration;
        this.date = date;
        this.startTime = startTime;
        this.presenter = presenter;
        this.producer = producer;
    }
    private Timestamp date;
    private Timestamp  startTime;
    private Timestamp  endTime;

    public ProgramSlot(Timestamp date, Timestamp startTime) {
        this.date = date;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "ProgramSlot{" + "name=" + name + ", duration=" + duration + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + ", presenter=" + presenter + ", producer=" + producer + '}';
    }

    public Timestamp  getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp  endTime) {
        this.endTime = endTime;
    }
    private String presenter;
    private String producer;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp  getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp  startTime) {
        this.startTime = startTime;
    }

}
