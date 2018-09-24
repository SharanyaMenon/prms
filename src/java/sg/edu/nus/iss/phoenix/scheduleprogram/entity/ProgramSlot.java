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

    public ProgramSlot(String name, Time typicalDuration, Date date, Date  startTime, String presenter, String producer) {
        this.name = name;
        this.duration = typicalDuration;
        this.date = date;
        this.startTime = startTime;
        this.presenter = presenter;
        this.producer = producer;
    }
    private Date date;
    private Date  startTime;
    private Date  endTime;

    public ProgramSlot(Date date, Date startTime) {
        this.date = date;
        this.startTime = startTime;
    }

    public Date  getEndTime() {
        return endTime;
    }

    public void setEndTime(Date  endTime) {
        this.endTime = endTime;
    }
    private String presenter;
    private String producer;

    public ProgramSlot() {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date  getStartTime() {
        return startTime;
    }

    public void setStartTime(Date  startTime) {
        this.startTime = startTime;
    }

}
