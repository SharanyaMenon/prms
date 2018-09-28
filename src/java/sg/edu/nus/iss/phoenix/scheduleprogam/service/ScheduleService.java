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
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public boolean processCreate(ProgramSlot programSlot) {

        try {
            Calendar calendar = computeEndTime(programSlot);
            programSlot.setEndTime(new Time(calendar.getTime().getTime()));
            

//            boolean isOverlap = checkForOverlap(programSlot);
//            if (!isOverlap) {
                scheduleDao.create(programSlot);
                
//            }

        } catch (ParseException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Calendar computeEndTime(ProgramSlot programSlot) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(programSlot.getStartTime().getTime());
        System.out.println("Original = " + calendar.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = sdf.parse(programSlot.getDuration().toString());
        int hours = date.getHours();
        calendar.add(Calendar.HOUR, hours);
        int minutes = date.getMinutes();
        calendar.add(Calendar.MINUTE, minutes);
        System.out.println("Original = " + calendar.getTime().getTime());
        return calendar;

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

    public void processModify(ProgramSlot programSlot) {
        //check for overlap
        try {
            boolean isOverlap = checkForOverlap(programSlot);
            scheduleDao.update(programSlot);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     *
     * @param date
     * @param startingTime
     */
    public void processDelete(Date date, Time startingTime) {
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

    public boolean checkForOverlap(ProgramSlot programSlot) throws Exception {
        boolean isOverlap = false;
        
        
        Date newDate = programSlot.getDate();
        Time newStartTime = programSlot.getStartTime();
        System.out.println("Program Slot : " + programSlot.toString());
        System.out.println("");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date newDatecompare = sdf.parse(newDate.toString());
        
        Calendar newStartTimeCalendar = Calendar.getInstance();
        newStartTimeCalendar.setTimeInMillis(programSlot.getStartTime().getTime());
        
        Calendar newendTimeClaendar = Calendar.getInstance();
        newendTimeClaendar.setTimeInMillis(programSlot.getStartTime().getTime());
        try {
            List<ProgramSlot> programSlotList = scheduleDao.loadAll();
            for (int i = 0; i < programSlotList.size(); i++) {
                ProgramSlot pgSlot = programSlotList.get(i);
                System.out.println("pgSlot: " + pgSlot.toString());
                java.util.Date oldDateCompare = sdf.parse(pgSlot.getDate().toString());
                if (oldDateCompare.compareTo(newDatecompare) == 0) {
                    //its same day

                     Calendar startTimeCalendar = Calendar.getInstance();
                     startTimeCalendar.setTimeInMillis(pgSlot.getStartTime().getTime());
                     
                     Calendar enttimecalendar = Calendar.getInstance();
                     enttimecalendar.setTimeInMillis(pgSlot.getEndTime().getTime());
                     
                     if (newStartTimeCalendar.before(enttimecalendar) && newendTimeClaendar.after(startTimeCalendar)){
                         isOverlap = false;
                     }

                     
//                     int beforeStart = newendTimeClaendar.compareTo(startTimeCalendar);
//                     int afterend = newendTimeClaendar.compareTo(enttimecalendar);
//                     System.out.println("before " +beforeStart +"after " +afterend);
//                     if (beforeStart <1 && afterend >1){
//                         isOverlap = false;
//                     }
////                     if (startTimeCalendar.compareTo(enttimecalendar) < 1){
////                          isOverlap = false;
////                     }
                     else {
                         isOverlap = true;
                         break;
                     }
//                    Time startTime = pgSlot.getStartTime();
//                    Time endTime = pgSlot.getEndTime();

//                    if (newStartTime.getTime() >= startTime.getTime() && newStartTime.getTime() <= endTime.getTime()) {
//                        isOverlap = false;
//                    } else {
//                        isOverlap = true;
//                    }
                    System.out.println("isOverlap :" + isOverlap);
                } else {
                    // not on same day
                    isOverlap = false;
                    System.out.println(" not on same day isOverlap :" + isOverlap);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            List<ProgramSlot> programSlotList = scheduleDao.loadAll();
//
//            for (int i = 0; i < programSlotList.size(); i++) {
//
//                ProgramSlot pgSlot = programSlotList.get(i);
//
//                String existingDateStr = dateFormatter.format(pgSlot.getDate());
//                java.util.Date existingDate = dateFormatter.parse(existingDateStr);
//
//                String newDateStr = dateFormatter.format(programSlot.getDate());
//                java.util.Date newDate = dateFormatter.parse(newDateStr);
//
//                String existingTimeStr = dateFormatter.format(pgSlot.getStartTime());
//                java.util.Date existingTime = dateFormatter.parse(existingTimeStr);
//
//                String newTimeStr = dateFormatter.format(programSlot.getStartTime());
//                java.util.Date newTime = dateFormatter.parse(newTimeStr);
//
//                if (existingDate.compareTo(newDate) == 0) {
//
//                    if (date1.compareTo(date2) > 0) {
//                        System.out.println("Date1 is after Date2");
//                    } else if (date1.compareTo(date2) < 0) {
//                        System.out.println("Date1 is before Date2");
//                    } else if (date1.compareTo(date2) == 0) {
//                        System.out.println("Date1 is equal to Date2");
//                    } else {
//                        System.out.println("How to get here?");
//                    }
//                    System.out.println("Date1 is after Date2");
//                } else {
//                    isOverlap = false;
//                }
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return isOverlap;

    }
    
    public void createAnnualSchedule(int year, String userName){
        
    }

}
