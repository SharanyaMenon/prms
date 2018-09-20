/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.radioprogram.dao.ProgramDAO;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleDao;

/**
 *
 * @author projects
 */
public interface DAOFactory {

	ProgramDAO getProgramDAO();

	RoleDao getRoleDAO();
        //test comment

	UserDao getUserDAO();
        
        ScheduleDao getScheduleDAO();
	
}
