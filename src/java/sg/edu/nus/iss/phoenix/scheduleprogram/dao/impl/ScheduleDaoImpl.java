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
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.scheduleprogram.dao.ScheduleDao;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author shara
 */
public class ScheduleDaoImpl implements ScheduleDao {

    Connection connection;

    @Override
    public ProgramSlot createValueObject() {
        return new ProgramSlot();
    }

    @Override
    public ProgramSlot getObject(String name) throws NotFoundException, SQLException {
        ProgramSlot valueObject = createValueObject();
        valueObject.setName(name);
        load(valueObject);
        return valueObject;

    }

    @Override
    public void load(ProgramSlot valueObject) throws NotFoundException, SQLException {
        if (valueObject.getName() == null) {
            // System.out.println("Can not select without Primary-Key!");
            throw new NotFoundException("Can not select without Primary-Key!");
        }

        String sql = "SELECT * FROM `radio-program` WHERE (`name` = ? ); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, valueObject.getName());

            singleQuery(stmt, valueObject);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
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

                pgSlot.setTypicalDuration(result.getTime("duration"));
                pgSlot.setDate(result.getDate("dateOfProgram"));
                pgSlot.setStartTime(result.getTime("startTime"));
                pgSlot.setName(result.getString("program-name"));
                pgSlot.setId(result.getString("slot_id"));

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
                valueObject.setTypicalDuration(result
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

    @Override
    public List<ProgramSlot> loadAll() throws SQLException {
        openConnection();
        String sql = "SELECT * FROM `program-slot` ORDER BY `name` ASC; ";
        List<ProgramSlot> searchResults = listQuery(connection
                .prepareStatement(sql));
        closeConnection();
        System.out.println("record size" + searchResults.size());
        return searchResults;

    }

    @Override
    public void create(ProgramSlot programSlot) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        openConnection();

        try {
            sql = "INSERT INTO `program-slot` (`duration`, `dateOfProgram`, `startTime`, `program-name`, `slot_id`) VALUES (?,?,?,?,?); ";
            stmt = connection.prepareStatement(sql);
            stmt.setTime(1, programSlot.getTypicalDuration());
            stmt.setDate(2, programSlot.getDate());
            stmt.setTime(3, programSlot.getStartTime());
            stmt.setString(4, programSlot.getName());
            stmt.setString(5, programSlot.getId());

            int rowcount = databaseUpdate(stmt);
            if (rowcount != 1) {
                // System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

    }

    @Override
    public void save(ProgramSlot programSlot) throws NotFoundException, SQLException {
//        String sql = "UPDATE `program-slot` SET `desc` = ?, `typicalDuration` = ? WHERE (`program-name` = ? ); ";
//        PreparedStatement stmt = null;
//        openConnection();
//        try {
//            stmt = connection.prepareStatement(sql);
//            stmt.setString(1, valueObject.getDescription());
//            stmt.setTime(2, valueObject.getTypicalDuration());
//
//            stmt.setString(3, valueObject.getName());
//
//            int rowcount = databaseUpdate(stmt);
//            if (rowcount == 0) {
//                // System.out.println("Object could not be saved! (PrimaryKey not found)");
//                throw new NotFoundException(
//                        "Object could not be saved! (PrimaryKey not found)");
//            }
//            if (rowcount > 1) {
//                // System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
//                throw new SQLException(
//                        "PrimaryKey Error when updating DB! (Many objects were affected!)");
//            }
//        } finally {
//            if (stmt != null) {
//                stmt.close();
//            }
//            closeConnection();
//        }

    }

    @Override
    public void delete(ProgramSlot valueObject) throws NotFoundException, SQLException {
        if (valueObject.getName() == null) {
            // System.out.println("Can not delete without Primary-Key!");
            throw new NotFoundException("Can not delete without Primary-Key!");
        }

        String sql = "DELETE FROM `radio-program` WHERE (`name` = ? ); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, valueObject.getName());

            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                // System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public void deleteAll(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramSlot> searchMatching(ProgramSlot valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
    }

}
