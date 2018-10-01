/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao;

import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule;

/**
 *
 * @author sharanya
 */
public interface ScheduleDao {

    /**
     * createValueObject-method. This method is used when the Dao class needs to
     * create new value object instance. The reason why this method exists is
     * that sometimes the programmer may want to extend also the valueObject and
     * then this method can be over-rided to return extended valueObject.
     *
     * @return
     */
    public abstract ProgramSlot createValueObject();

    /**
     * LoadAll-method. This will read all contents from database table and build
     * a List containing valueObjects.
     *
     * @return
     * @throws SQLException
     */
    public abstract List<ProgramSlot> loadAll() throws SQLException;

    /**
     * create-method. This will create new row in database according to supplied
     * programSlot contents. Make sure that values for all NOT NULL columns are
     * correctly specified. Also, if this table does not use automatic
     * surrogate-keys the primary-key must be specified. After INSERT command
     * this method will read the generated primary-key back to programSlot if
     * automatic surrogate-keys were used.
     *
     * @param programSlot
     * @return
     * @throws SQLException
     */
    public abstract boolean create(ProgramSlot programSlot) throws SQLException;

    /**
     * This method will save the current state of valueObject to database. Save
     * can not be used to create new instances in database, so upper layer must
     * make sure that the primary-key is correctly specified. Primary-key will
     * indicate which instance is going to be updated in database. If save can
     * not find matching row, NotFoundException will be thrown.
     *
     * @param programSlot
     * @return
     * @throws NotFoundException
     * @throws SQLException
     */
    public abstract boolean update(ProgramSlot programSlot)
            throws NotFoundException, SQLException;

    /**
     * This method will remove the information from database as identified by by
     * primary-key in supplied valueObject. Once valueObject has been deleted it
     * can not be restored by calling save. Restoring can only be done using
     * create method but if database is using automatic surrogate-keys, the
     * resulting object will have different primary-key than what it was in the
     * deleted object.
     *
     * @param programSlot
     * @return
     * @throws NotFoundException
     * @throws SQLException
     */
    public abstract boolean delete(ProgramSlot programSlot)
            throws NotFoundException, SQLException;

    /**
     * This method is used to create Weekly Schedule
     *
     * @param weeklySchedule
     * @throws SQLException
     */
    public void addWs(WeeklySchedule weeklySchedule) throws SQLException;

    /**
     * This method is used to create Annual Schedule
     *
     * @param annualSchedule
     * @throws SQLException
     */
    public void addAS(AnnualSchedule annualSchedule) throws SQLException;

    /**
     * This method is used to read Annual Schedule
     *
     * @param year
     * @return
     * @throws SQLException
     */
    public boolean readAS(int year) throws SQLException;

}
