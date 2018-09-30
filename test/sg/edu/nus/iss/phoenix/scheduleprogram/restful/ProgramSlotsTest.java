/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.scheduleprogam.service.ReviewSelectPresenterProducerService;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author SuganthiSugumar
 */
@RunWith(MockitoJUnitRunner.class)
public class ProgramSlotsTest {
    private static long currentTime = System.currentTimeMillis();
    ArrayList<ProgramSlot> programSlots = new ArrayList<ProgramSlot>();
    @Mock
    ProgramSlots pgSlots ;
    
    public ProgramSlotsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        pgSlots= mock(ProgramSlots.class);
        ProgramSlot pgSlot1 = new ProgramSlot();
        pgSlot1.setName("charity");
        pgSlot1.setPresenter("presnter");
        pgSlot1.setProducer("producerdfczcfsdf");
        pgSlot1.setDate(new Date(currentTime));
        pgSlot1.setStartTime(new Time(currentTime));
        pgSlot1.setDuration(new Time(currentTime));
        ProgramSlot pgSlot2 = new ProgramSlot();
        pgSlot2.setName("dance");
        pgSlot2.setPresenter("presnter");
        pgSlot2.setProducer("producerdfc");
        pgSlot2.setDate(new Date(currentTime));
        pgSlot2.setStartTime(new Time(currentTime));
        pgSlot2.setDuration(new Time(currentTime));
        programSlots.add(pgSlot1);
        programSlots.add(pgSlot2);
        
        when(pgSlots.getPgSlots()).thenReturn(programSlots);
        //when(pgSlots.setPgSlots(org.mockito.Matchers.a))
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPgSlots method, of class ProgramSlots.
     */
    @Test
    public void testGetPgSlotsNull() {
        System.out.println("getPgSlotsNull");
        ProgramSlots psSlots= new ProgramSlots();
        ArrayList<ProgramSlot> expResult = null;
        ArrayList<ProgramSlot> result = psSlots.getPgSlots();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPgSlots() {
        System.out.println("getPgSlots");
//        ProgramSlots psSlots= new ProgramSlots();
//        ArrayList<ProgramSlot> expResult = null;
        ArrayList<ProgramSlot> result = pgSlots.getPgSlots();
        assertThat(result,hasSize(2));
    }

    /**
     * Test of hashCode method, of class ProgramSlots.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ProgramSlots instance = new ProgramSlots();
        int expResult = 623;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class ProgramSlots.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ProgramSlots instance = new ProgramSlots();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPgSlots method, of class ProgramSlots.
     */
    @Test
    public void testSetPgSlots() {
        System.out.println("setPgSlots");
        ProgramSlots instance = new ProgramSlots();
        instance.setPgSlots(programSlots);
        ArrayList<ProgramSlot> expected = instance.getPgSlots();
        assertThat(expected, hasSize(2));
        
    }
    
}
