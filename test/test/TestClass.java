/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.restful.ProgramSlots;
import sg.edu.nus.iss.phoenix.scheduleprogram.restful.ScheduleRestService;

/**
 *
 * @author shara
 */
public class TestClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        try {
            testClass.createPgSlot();
//    testClass.getAllPgSlots();
//            testClass.delete();
//testClass.update();
//            testClass.test();
//testClass.t();
        } catch (Exception ex) {
            Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createPgSlot() throws ParseException {
        ScheduleRestService restService = new ScheduleRestService();
        ProgramSlot programSlot = new ProgramSlot();
        programSlot.setName("charity");
        programSlot.setPresenter("presnter");
        programSlot.setProducer("producerdfczcfsdf");
        programSlot.setDate(new Date(System.currentTimeMillis()));
        programSlot.setStartTime(new Time(System.currentTimeMillis()));
        programSlot.setDuration(new Time(System.currentTimeMillis()));
   
        restService.createSchedule(programSlot);
    }

//    private void delete() {
//        ScheduleRestService restService = new ScheduleRestService();
//        restService.deleteScheduleProgram("2018-09-24 00:00:00", "2018-09-24 20:34:00");
//
//    }
//
//    private void update() throws ParseException {
//        ScheduleRestService restService = new ScheduleRestService();
//        ProgramSlot programSlot = new ProgramSlot();
//
//        programSlot.setName("charity");
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date startTime = sdf.parse("2018-09-24 20:34:00");
//        Timestamp stTime = new Timestamp(startTime.getTime());
//        java.util.Date date = sdf.parse("2018-09-24 00:00:00");
//        Timestamp dt = new Timestamp(date.getTime());
//        programSlot.setDate(dt);
//
//        programSlot.setEndTime(new Timestamp(System.currentTimeMillis()));
//        programSlot.setPresenter("hi");
//        programSlot.setProducer("haaaaiiiiiiiii");
//        programSlot.setStartTime(stTime);
//        programSlot.setDuration(new Time(System.currentTimeMillis() + 1000));
//        restService.updateProgramSlot(programSlot);
//
//    }

    public void test() {
        Date now = new Date(System.currentTimeMillis());
        Timestamp ts = new Timestamp(now.getTime());
        System.out.println(ts);

    }

    public void t() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        java.util.Date d1 =  df.parse("20:10:30"); //date 1
        java.util.Date d2 =  df.parse("5:10:30"); // date 2
        long sum = d1.getTime() + d2.getTime();
        System.out.println(df.format(new Date(sum)));
    }
    
//    public void getAllPgSlots(){
//        ScheduleRestService restService = new ScheduleRestService();
//        ProgramSlots programSlots = restService.getAllProgramSlot();
//        ArrayList<ProgramSlot> pgSlotList = programSlots.getPgSlots();
//        for (int i = 0; i < pgSlotList.size(); i++) {
//            ProgramSlot pgSlot =  pgSlotList.get(i);
//            System.out.println(pgSlot.toString());;
//        }
//        
//        
//    }
    

}
