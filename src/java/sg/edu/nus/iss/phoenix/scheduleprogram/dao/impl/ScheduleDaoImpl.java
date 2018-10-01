/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleDao;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.WeeklySchedule;

/**
 *
 * @author sharanya
 */
public class ScheduleDaoImpl implements ScheduleDao {

    Connection connection;


    /**
     * Returns the new Object
     * @return 
     */
     @Override
    public ProgramSlot createValueObject() {
        return new ProgramSlot();
    }

    private void openConnection() {
        try {
            Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(DBConstants.dbUrl,
                    DBConstants.dbUserName, DBConstants.dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected List<ProgramSlot> listQuery(PreparedStatement stmt) throws SQLException {

        ArrayList<ProgramSlot> pgSlotList = new ArrayList<>();
        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();

            while (result.next()) {

                ProgramSlot pgSlot = createValueObject();
                pgSlot.setDuration(result.getTime("duration"));
                pgSlot.setDate(result.getDate("dateOfProgram"));
                pgSlot.setStartTime(result.getTime("startTime"));
                pgSlot.setName(result.getString("program-name"));
                pgSlot.setPresenter(result.getString("producer"));
                pgSlot.setProducer(result.getString("presenter"));
                pgSlot.setEndTime(result.getTime("endTime"));
                pgSlotList.add(pgSlot);

            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

        return (List<ProgramSlot>) pgSlotList;
    }

    private void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void singleQuery(PreparedStatement stmt, ProgramSlot valueObject)
            throws NotFoundException, SQLException {

        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();

            if (result.next()) {

                valueObject.setName(result.getString("name"));
//				valueObject.setDescription(result.getString("desc"));
                valueObject.setDuration(result
                        .getTime("typicalDuration"));

            } else {
                // System.out.println("RadioProgram Object Not Found!");
                throw new NotFoundException("RadioProgram Object Not Found!");
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }
 
    /**
     * Method to load All ProgramSlots from Database
     * @return
     * @throws SQLException 
     */
    @Override
    public List<ProgramSlot> loadAll() throws SQLException {
        openConnection();
        String sql = "SELECT * FROM `program-slot` ORDER BY `program-name` ASC; ";
        List<ProgramSlot> searchResults = listQuery(connection.prepareStatement(sql));
        closeConnection();
        System.out.println("record size" + searchResults.size());
        return searchResults;

    }

    /**
     * Method to create Program Slot in Database
     * @param programSlot
     * @return
     * @throws SQLException 
     */
    @Override
    public boolean create(ProgramSlot programSlot) throws SQLException {
        PreparedStatement stmt = null;
        openConnection();

        try {
            String sql = "INSERT INTO `program-slot` (`duration`, `dateOfProgram`, `startTime`, `program-name`, `presenter`, `producer` , `endTime`) VALUES (?,?,?,?,?,?,?); ";
            stmt = connection.prepareStatement(sql);
            stmt.setTime(1, programSlot.getDuration());
            stmt.setDate(2, programSlot.getDate());
            stmt.setTime(3, programSlot.getStartTime());
            stmt.setString(4, programSlot.getName());
            stmt.setString(5, programSlot.getPresenter());
            stmt.setString(6, programSlot.getProducer());
            stmt.setTime(7, programSlot.getEndTime());

            int rowcount = databaseUpdate(stmt);
            if (rowcount != 1) {
                // System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            } else {
                return true;
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

    }
/**
 * Method to update Program Slot in Database
 * @param programSlot
 * @return
 * @throws NotFoundException
 * @throws SQLException 
 */
    @Override
    public boolean update(ProgramSlot programSlot) throws NotFoundException, SQLException {
        String sql = "UPDATE `program-slot` SET `presenter` = ?, `producer` = ?,  `duration` = ?, `program-name` = ? WHERE (`dateOfProgram` = ? and `startTime` = ? ); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, programSlot.getPresenter());
            stmt.setString(2, programSlot.getProducer());
            stmt.setTime(3, programSlot.getDuration());
            stmt.setString(4, programSlot.getName());
            stmt.setDate(5, programSlot.getDate());
            stmt.setTime(6, programSlot.getStartTime());

            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                // System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were affected!)");
            } else {
                return true;
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

    }
/***
 * Method to delete Program Slot from Database
 * @param programSlot
 * @return
 * @throws NotFoundException
 * @throws SQLException 
 */
    @Override
    public boolean delete(ProgramSlot programSlot) throws NotFoundException, SQLException {
        boolean isDeleted = false;
        if (programSlot.getStartTime() == null || programSlot.getDate() == null) {
            isDeleted = false;
            throw new NotFoundException("Can not delete without Primary-Key!");
        }

        String sql = "DELETE FROM `program-slot` WHERE (`dateOfProgram` = ? and `startTime` = ? ); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setDate(1, programSlot.getDate());
            stmt.setTime(2, programSlot.getStartTime());

            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                isDeleted = false;
                throw new NotFoundException(
                        "Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                isDeleted = false;
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were deleted!)");
            } else {
                isDeleted = true;
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
        return isDeleted;
    }

    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
    }

    
    /**
     * Method to add Weekly Schedule to Database
     * @param weeklySchedule
     * @throws SQLException
     */
    @Override
    public void addWs(WeeklySchedule weeklySchedule) throws SQLException{
        
         PreparedStatement stmt = null;
        openConnection();

        try {
            String sql = "INSERT INTO `weekly-schedule` (`startDate`, `startTime`, `assignedBy`) VALUES (?,?,?); ";
            stmt = connection.prepareStatement(sql);
            stmt.setDate(1, weeklySchedule.getStartDate());
            stmt.setTime(2, weeklySchedule.getStartTime());
            stmt.setString(3, weeklySchedule.getAssignedBy());
            

            int rowcount = databaseUpdate(stmt);
            if (rowcount != 1) {
                // System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            } else {
//                return true;
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
        
    }
    /**
     * Method to add Annual Schedule to Database
     * @param annualSchedule
     * @throws SQLException 
     */
    public void addAS(AnnualSchedule annualSchedule)throws SQLException{
        
         PreparedStatement stmt = null;
        openConnection();

        try {
            String sql = "INSERT INTO `annual-schedule` (`year`, `assingedBy`) VALUES (?,?); ";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, annualSchedule.getYear());
            stmt.setString(2, annualSchedule.getAssignedBy());
                      

            int rowcount = databaseUpdate(stmt);
            if (rowcount != 1) {
                // System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            } else {
//                return true;
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }
    
    /**
     * Method to read Annual Schedule from Database
     * @param year
     * @return
     * @throws SQLException 
     */
    @Override
    public boolean readAS(int year) throws SQLException {
        boolean isPresent = false;
        
        openConnection();
        String sql = "SELECT year FROM `annual-schedule` WHERE  (`year` = "+year+")";
        int y = getYear(connection.prepareStatement(sql));
        if(y!=0){
            isPresent = true;
        }
        closeConnection();
        return isPresent;
    }
    
    protected int getYear(PreparedStatement stmt) throws SQLException {
      
        int year = 0;
        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();

            while (result.next()) {
                year = result.getInt("year");
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

        return year;
    }

}
