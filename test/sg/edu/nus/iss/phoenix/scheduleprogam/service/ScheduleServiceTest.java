/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogam.service;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import static org.hamcrest.Matchers.containsString;
import org.hamcrest.collection.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.isA;
import org.mockito.runners.MockitoJUnitRunner;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleDao;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl.ScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author sharanya
 */
@RunWith(MockitoJUnitRunner.class)
public class ScheduleServiceTest {

//    private static ScheduleService mockScheduleService;
    @Mock
    private static ScheduleDao mockScheduleDao;
    @Mock
    private static ScheduleDaoImpl mockScheduleDaoImpl;
    private static ProgramSlot pgSlot1;
    private static ProgramSlot pgSlot2;
    ScheduleService service;

    private static long currentTime = System.currentTimeMillis();

    public ScheduleServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException, NotFoundException {

        mockScheduleDao = mock(ScheduleDao.class);
        mockScheduleDaoImpl = mock(ScheduleDaoImpl.class);
        service = new ScheduleService();
        service.setScheduleDao(mockScheduleDao);
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
//        when(mockScheduleService.findAllProgramSlot()).thenReturn(pgSlotList);
        when(mockScheduleDao.loadAll()).thenReturn(pgSlotList);
//        when(mockScheduleDao.loadAll()).thenReturn(pgSlotList);
        when(mockScheduleDao.create(pgSlot1)).thenReturn(false);
        when(mockScheduleDao.update(pgSlot1)).thenReturn(true);
//        doNothing().when(mockScheduleDao).create(isA(ProgramSlot.class));
//        doNothing().when(mockScheduleDaoImpl).create(isA(ProgramSlot.class));
//        doNothing().when(mockScheduleDaoImpl).delete(isA(ProgramSlot.class));
//        doNothing().when(mockScheduleDao).delete(isA(ProgramSlot.class));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findAllProgramSlot method, of class ScheduleService.
     */
    @Test
    public void testFindAllProgramSlot() {

//        ProgramSlot expectedPgSlot1 = new ProgramSlot();
//        expectedPgSlot1.setName("charity");
//        expectedPgSlot1.setPresenter("presnter");
//        expectedPgSlot1.setProducer("producerdfczcfsdf");
//        expectedPgSlot1.setDate(new Date(currentTime));
//        expectedPgSlot1.setStartTime(new Time(currentTime));
//        expectedPgSlot1.setDuration(new Time(currentTime));
//
//        ProgramSlot expectedPgSlot2 = new ProgramSlot();
//        expectedPgSlot2.setName("charity");
//        expectedPgSlot2.setPresenter("presnter");
//        expectedPgSlot2.setProducer("producerdfczcfsdf");
//        expectedPgSlot2.setDate(new Date(currentTime));
//        expectedPgSlot2.setStartTime(new Time(currentTime));
//        expectedPgSlot2.setDuration(new Time(currentTime));
//
//        ArrayList<ProgramSlot> expectedPgSlotList = new ArrayList<ProgramSlot>();
//        expectedPgSlotList.add(expectedPgSlot1);
//        expectedPgSlotList.add(expectedPgSlot2);
        System.out.println("findAllProgramSlot");
//        ScheduleService scheduleService = new ScheduleService();
//
//        System.out.println(expectedPgSlot1);
//        System.out.println(expectedPgSlot2);

        ArrayList<ProgramSlot> result = service.findAllProgramSlot();
        String matchName = result.get(0).getName();
        assertThat(matchName, containsString("charity"));
    }

    /**
     * Test of processDelete method, of class ScheduleService.
     */
    @Test
    public void testProcessDelete() {
        System.out.println("processDelete");
        Date date = new Date(currentTime);
        Time startingTime = new Time(currentTime);
        ScheduleService instance = new ScheduleService();
        instance.setScheduleDao(mockScheduleDao);
        boolean result = instance.processDelete(date, startingTime);
        System.out.println(result);
        Assert.assertFalse(result);

    }

    /**
     * Test of processCreate method, of class ScheduleService.
     */
    @Test
    public void testProcessCreate() {
        System.out.println("processCreate");

        ScheduleService service = new ScheduleService();
        service.setScheduleDao(mockScheduleDao);
        boolean expResult = true;
        ProgramSlot expectedPgSlot1 = new ProgramSlot();
        expectedPgSlot1.setName("charity");
        expectedPgSlot1.setPresenter("presnter");
        expectedPgSlot1.setProducer("producerdfczcfsdf");
        expectedPgSlot1.setDate(new Date(currentTime));
        expectedPgSlot1.setStartTime(new Time(currentTime));
        expectedPgSlot1.setDuration(new Time(currentTime));

        boolean result = service.processCreate(expectedPgSlot1);
        System.out.println(expResult);
        System.out.println(result);

        Assert.assertFalse(result);

    }

    /**
     * Test of processModify method, of class ScheduleService.
     */
    @Test
    public void testProcessModify() {
        System.out.println("processModify");

        ProgramSlot expectedPgSlot1 = new ProgramSlot();
        expectedPgSlot1.setName("charity");
        expectedPgSlot1.setPresenter("presnter");
        expectedPgSlot1.setProducer("producerdfczcfsdf");
        expectedPgSlot1.setDate(new Date(currentTime));
        expectedPgSlot1.setStartTime(new Time(currentTime));
        expectedPgSlot1.setDuration(new Time(currentTime));
        ScheduleService service = new ScheduleService();
        service.setScheduleDao(mockScheduleDao);
        boolean result = service.processModify(expectedPgSlot1);
        Assert.assertTrue(result);

    }

    //    /**
//     * Test of checkForOverlap method, of class ScheduleService.
//     */
//    @Test
//    public void testCheckForOverlap() {
//        try {
//            System.out.println("checkForOverlap");
//            ProgramSlot programSlot = null;
//            ScheduleService instance = new ScheduleService();
//            boolean expResult = false;
//            boolean result = instance.checkForOverlap(programSlot);
//            assertEquals(expResult, result);
//            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
//        } catch (Exception ex) {
//            Logger.getLogger(ScheduleServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
