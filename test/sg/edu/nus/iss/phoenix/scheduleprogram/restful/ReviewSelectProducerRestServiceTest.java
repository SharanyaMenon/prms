/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
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
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.scheduleprogam.service.ReviewSelectPresenterProducerService;

/**
 *
 * @author SuganthiSugumar
 */
@RunWith(MockitoJUnitRunner.class)
public class ReviewSelectProducerRestServiceTest {
    
    @Mock
    private static DAOFactoryImpl factory;
    @Mock 
    private static UserDao userDao;
    
    private static User user1;
    private static User user2;
    private static List<User> userList = new ArrayList<User>();
    ReviewSelectPresenterProducerService service ;
    
    public ReviewSelectProducerRestServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        
        factory = mock(DAOFactoryImpl.class);
        userDao = mock(UserDao.class);
        service =  new ReviewSelectPresenterProducerService();
        service.setFactory(factory);
        service.setUserdao(userDao);
        
        user1 = new User();
        user2 = new User();
        
        user1.setAll("pointy", "pointy", "Head", "producer");
        user2.setAll("tommy", "hil", "THF", "producer");
        
        userList.add(user1);
        userList.add(user2);
        
        
        when(userDao.loadUserBasedOnRole("producer")).thenReturn(userList);
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPresenter method, of class ReviewSelectPresenterRestService.
     */
    @Test
    public void testGetPresenter() {
        System.out.println("getProducer");
        ArrayList<User> listUser = service.loadUserBasedOnRole("producer");
        String matchName = listUser.get(0).getName();
        ArrayList<Role> role = listUser.get(0).getRoles();
        String expResult = "Head";
        assertThat( matchName,containsString(expResult));
        assertThat(role,hasItem(hasProperty("role", is("producer"))));
    }
    
}
