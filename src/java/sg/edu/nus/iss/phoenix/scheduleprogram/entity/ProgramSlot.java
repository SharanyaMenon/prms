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
    private String id;
    private Time typicalDuration;

    private Date date;
    private Time startTime;

    public ProgramSlot(String name, String id, Time typicalDuration, Date date, Time startTime) {
        this.name = name;
        this.id = id;
        this.typicalDuration = typicalDuration;
        this.date = date;
        this.startTime = startTime;
    }

    public ProgramSlot() {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProgramSlot(String scheduleProgramName) {
        this.name = scheduleProgramName;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Time getTypicalDuration() {
        return typicalDuration;
    }

    public void setTypicalDuration(Time typicalDuration) {
        this.typicalDuration = typicalDuration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

}
