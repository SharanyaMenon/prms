/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Date;
import java.sql.Time;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.restful.ScheduleRestService;

/**
 *
 * @author shara
 */
public class TestClass {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.createPgSlot();
//        testClass.delete();
//testClass.update();
    }

    private void createPgSlot() {
        ScheduleRestService restService = new ScheduleRestService();
        ProgramSlot programSlot = new ProgramSlot();
        programSlot.setDate(new Date(System.currentTimeMillis()));
        programSlot.setName("charity");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        String currentTime = sdf.format(new Date(System.currentTimeMillis()));

        programSlot.setEndTime(new Date(System.currentTimeMillis()));
        programSlot.setPresenter("presnter");
        programSlot.setProducer("producer");
        programSlot.setStartTime(new Date(1537796341));
        programSlot.setDuration(new Time(1537796341));
        restService.createSchedule(programSlot);
    }

//    private void delete() {
//        ScheduleRestService restService = new ScheduleRestService();
//        restService.deleteScheduleProgram("charity");
//
//    }

    private void update() {
        ScheduleRestService restService = new ScheduleRestService();
        ProgramSlot programSlot = new ProgramSlot();
        programSlot.setDate(new Date(System.currentTimeMillis()));
        programSlot.setName("charity");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(new Date(System.currentTimeMillis()));

        programSlot.setEndTime(new Date(System.currentTimeMillis()));
        programSlot.setPresenter("hi");
        programSlot.setProducer("hai");
        programSlot.setStartTime(new Date(System.currentTimeMillis()));
        programSlot.setDuration(new Time(System.currentTimeMillis()+1000));
        restService.updateProgramSlot(programSlot);

    }

}
