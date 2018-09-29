/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Time;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author sharanya
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.duration);
        hash = 61 * hash + Objects.hashCode(this.date);
        hash = 61 * hash + Objects.hashCode(this.startTime);
        hash = 61 * hash + Objects.hashCode(this.endTime);
        hash = 61 * hash + Objects.hashCode(this.presenter);
        hash = 61 * hash + Objects.hashCode(this.producer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgramSlot other = (ProgramSlot) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.presenter, other.presenter)) {
            return false;
        }
        if (!Objects.equals(this.producer, other.producer)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        return true;
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
