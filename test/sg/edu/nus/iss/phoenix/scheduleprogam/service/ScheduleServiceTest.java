/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogam.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author shara
 */
public class ScheduleServiceTest {

    private static ScheduleService mockScheduleService;
    private static ProgramSlot pgSlot1;
    private static ProgramSlot pgSlot2;

    private static long currentTime = System.currentTimeMillis();

    public ScheduleServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        //Create mock object of BookDAL
        mockScheduleService = mock(ScheduleService.class);

        //Create few instances of Book class.
        pgSlot1 = new ProgramSlot();
        pgSlot1.setName("charity");
        pgSlot1.setPresenter("presnter");
        pgSlot1.setProducer("producerdfczcfsdf");
        pgSlot1.setDate(new Date(currentTime));
        pgSlot1.setStartTime(new Time(currentTime));
        pgSlot1.setDuration(new Time(currentTime));

        pgSlot2 = new ProgramSlot();
        pgSlot2.setName("charity");
        pgSlot2.setPresenter("presnter");
        pgSlot2.setProducer("producerdfczcfsdf");
        pgSlot2.setDate(new Date(currentTime));
        pgSlot2.setStartTime(new Time(currentTime));
        pgSlot2.setDuration(new Time(currentTime));

        System.out.println(pgSlot1);
        System.out.println(pgSlot2);

        ArrayList<ProgramSlot> pgSlotList = new ArrayList<ProgramSlot>();
        pgSlotList.add(pgSlot1);
        pgSlotList.add(pgSlot2);

        //Stubbing the methods of mocked BookDAL with mocked data. 
        when(mockScheduleService.findAllProgramSlot()).thenReturn(pgSlotList);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findAllProgramSlot method, of class ScheduleService.
     */
    @Test
    public void testFindAllProgramSlot() {

        ProgramSlot programSlot1 = new ProgramSlot();
        programSlot1.setName("charity");
        programSlot1.setPresenter("presnter");
        programSlot1.setProducer("producerdfczcfsdf");
        programSlot1.setDate(new Date(currentTime));
        programSlot1.setStartTime(new Time(currentTime));
        programSlot1.setDuration(new Time(currentTime));

        ProgramSlot programSlot2 = new ProgramSlot();
        programSlot2.setName("charity");
        programSlot2.setPresenter("presnter");
        programSlot2.setProducer("producerdfczcfsdf");
        programSlot2.setDate(new Date(currentTime));
        programSlot2.setStartTime(new Time(currentTime));
        programSlot2.setDuration(new Time(currentTime));
        ArrayList<ProgramSlot> pgSlotList = new ArrayList<ProgramSlot>();
        pgSlotList.add(programSlot1);
        pgSlotList.add(programSlot2);
        System.out.println("findAllProgramSlot");
        ScheduleService instance = new ScheduleService();

        System.out.println(programSlot1);
        System.out.println(programSlot2);
        ArrayList<ProgramSlot> result = instance.findAllProgramSlot();
        assertSame(pgSlotList, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of processCreate method, of class ScheduleService.
//     */
//    @Test
//    public void testProcessCreate() {
//        System.out.println("processCreate");
//        ProgramSlot programSlot = null;
//        ScheduleService instance = new ScheduleService();
//        boolean expResult = false;
//        boolean result = instance.processCreate(programSlot);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of processModify method, of class ScheduleService.
//     */
//    @Test
//    public void testProcessModify() {
//        System.out.println("processModify");
//        ProgramSlot programSlot = null;
//        ScheduleService instance = new ScheduleService();
//        instance.processModify(programSlot);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of processDelete method, of class ScheduleService.
//     */
//    @Test
//    public void testProcessDelete() {
//        System.out.println("processDelete");
//        Date date = null;
//        Time startingTime = null;
//        ScheduleService instance = new ScheduleService();
//        instance.processDelete(date, startingTime);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkForOverlap method, of class ScheduleService.
//     */
    @Test
    public void testCheckForOverlap() {
        System.out.println("checkForOverlap");
        ProgramSlot programSlot = null;
        ScheduleService instance = new ScheduleService();
        boolean expResult = false;
        boolean result = instance.checkForOverlap(programSlot);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
