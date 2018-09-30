/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author sharanya
 */
public class WeeklySchedule {

    private String assignedBy;

    private Date startDate;
    
    private Time startTime;

    public String getAssignedBy() {
        return assignedBy;
    }

    public WeeklySchedule(String assignedBy, Date startDate, Time startTime) {
        this.assignedBy = assignedBy;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    

}
