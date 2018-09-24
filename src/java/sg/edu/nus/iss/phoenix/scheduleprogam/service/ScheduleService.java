/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogam.service;

import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleDao;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author shara
 */
public class ScheduleService {
    
    private DAOFactoryImpl daoFactory;
    
    private ScheduleDao scheduleDao;
    
    public ScheduleService() {
        super();
        // Sorry. This implementation is wrong. To be fixed.
        daoFactory = new DAOFactoryImpl();
        scheduleDao = daoFactory.getScheduleDAO();
    }
    
    public ArrayList<ProgramSlot> findAllProgramSlot() {
        ArrayList<ProgramSlot> programSlotList = new ArrayList<ProgramSlot>();
        try {
            programSlotList = (ArrayList<ProgramSlot>) scheduleDao.loadAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch blocks
            e.printStackTrace();
        }
        return programSlotList;
        
    }
    
    public boolean processCreate(ProgramSlot programSlot) {
        //check for overlap        
        try {
//            Time startTime = programSlot.getStartTime();
//            Time duration = programSlot.getTypicalDuration();
//            getEndTime(startTime, duration);
            programSlot.setEndTime(programSlot.getStartTime());
            scheduleDao.create(programSlot);
        } catch (SQLException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public void processModify(ProgramSlot programSlot) {
        //check for overlap
        try {
            scheduleDao.update(programSlot);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void processDelete(Date date, Date startingTime) {
        try {
            ProgramSlot programSlot = new ProgramSlot(date, startingTime);
            scheduleDao.delete(programSlot);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    
//    public void inputProgramSlot() {
//        
//    }

//    private void getEndTime(Time startTime, Time duration) {
//        String myTime = "14:10";
//        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
//        df.format(new Date(startTime));
//        Date d = df.parse(startTime.toString());
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(d);
//        cal.add(Calendar.MINUTE, 10);
//        String newTime = df.format(cal.getTime());
//
//    }
}
