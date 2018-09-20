/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleDao;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.radioprogram.dao.ProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author shara
 */
public class ScheduleService {

    private DAOFactoryImpl factory;
    private ScheduleDao scheduleDao;

    public ScheduleService() {
        super();
        // Sorry. This implementation is wrong. To be fixed.
        factory = new DAOFactoryImpl();
	scheduleDao = factory.getScheduleDAO();
    }

    public ArrayList<ProgramSlot> findAllProgramSlot() {
        ArrayList<ProgramSlot> currentList = new ArrayList<ProgramSlot>();

        return currentList;

    }

    public void processCreate(ProgramSlot programSlot) {

    }

    public void processModify(ProgramSlot programSlot) {

    }

    public void processDelete(String pgName) {

    }

    public void inputProgramSlot() {

    }
}
