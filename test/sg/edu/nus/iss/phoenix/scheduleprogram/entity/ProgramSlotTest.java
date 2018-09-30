/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Date;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SuganthiSugumar
 */
public class ProgramSlotTest {
    private static long currentTime = System.currentTimeMillis();
    ProgramSlot pgSlot1;
    
    public ProgramSlotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pgSlot1 = new ProgramSlot();
        pgSlot1.setName("charity");
        pgSlot1.setPresenter("presnter");
        pgSlot1.setProducer("producerdfczcfsdf");
        pgSlot1.setDate(new Date(currentTime));
        pgSlot1.setStartTime(new Time(currentTime));
        pgSlot1.setDuration(new Time(currentTime));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class ProgramSlot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ProgramSlot instance = new ProgramSlot();
        //String expResult = null;
        String result = instance.toString();
        assertNotNull(result);
        
    }

    /**
     * Test of getEndTime method, of class ProgramSlot.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        ProgramSlot ps = new ProgramSlot();
        ps.setEndTime(new Time(currentTime));
        Time result = ps.getEndTime();
        assertNotNull( result);
        
    }

    /**
     * Test of setEndTime method, of class ProgramSlot.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        Time endTime = new Time(currentTime);
        ProgramSlot instance = new ProgramSlot();
        instance.setEndTime(endTime);
        assertEquals(instance.getEndTime(),endTime);
        
    }

    /**
     * Test of getPresenter method, of class ProgramSlot.
     */
    @Test
    public void testGetPresenter() {
        System.out.println("getPresenter");
        ProgramSlot instance = new ProgramSlot();
        String expResult = "presenter";
        instance.setPresenter("presenter");
        String result = instance.getPresenter();
        assertEquals(expResult, result);
        
    }


    /**
     * Test of hashCode method, of class ProgramSlot.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ProgramSlot instance = new ProgramSlot();
        int expResult = 377362035;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class ProgramSlot.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ProgramSlot instance = new ProgramSlot();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getProducer method, of class ProgramSlot.
     */
    @Test
    public void testGetProducer() {
        System.out.println("getProducer");
        ProgramSlot instance = new ProgramSlot();
        String expResult = "producer";
        instance.setProducer("producer");
        String result = instance.getProducer();
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of getName method, of class ProgramSlot.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        ProgramSlot instance = new ProgramSlot();
        String expResult = "pointy";
        instance.setName("pointy");
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    /**
     * Test of getDuration method, of class ProgramSlot.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        ProgramSlot instance = new ProgramSlot();
        Time expResult = new Time(currentTime);
        instance.setDuration(new Time(currentTime));
        Time result = instance.getDuration();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getDate method, of class ProgramSlot.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        ProgramSlot instance = new ProgramSlot();
        Date expResult = new Date(currentTime);
        instance.setDate(new Date(currentTime));
        Date result = instance.getDate();
        assertEquals(expResult, result);
        
    }

   
    /**
     * Test of getStartTime method, of class ProgramSlot.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        ProgramSlot instance = new ProgramSlot();
        Time expResult = new Time(currentTime);
        instance.setStartTime(new Time(currentTime));
        Time result = instance.getStartTime();
        assertEquals(expResult, result);
    }

}
