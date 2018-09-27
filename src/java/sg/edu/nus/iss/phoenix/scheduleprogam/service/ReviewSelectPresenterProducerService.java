/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogam.service;

/**
 *
 * @author GengHui
 */




import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.dao.ProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
public class ReviewSelectPresenterProducerService {
    //Use UserDao
        DAOFactoryImpl factory;
	UserDao userdao;

	public ReviewSelectPresenterProducerService() {
		super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
		userdao = factory.getUserDAO();
	}

//	public List<User> getProducer() {
//            List<User> data = null;
//            try {
//                data = userdao.loadUserBasedOnRole("producer");
//            } catch (SQLException ex) {
//                Logger.getLogger(ReviewSelectPresenterProducerService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return data; 
//	}
//        
//        public List<User> getPrsenter() {
//            List<User> data = null;
//            try {
//                data = userdao.loadUserBasedOnRole("presenter");
//            } catch (SQLException ex) {
//                Logger.getLogger(ReviewSelectPresenterProducerService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return data; 
//	}
        
        public ArrayList <User> loadUserBasedOnRole(String role) {
		ArrayList<User> currentList = new ArrayList<User>();
		try {
			currentList = (ArrayList<User>) userdao.loadUserBasedOnRole(role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;

	}
        

}
