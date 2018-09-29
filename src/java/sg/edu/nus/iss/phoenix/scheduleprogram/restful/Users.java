/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author Administrator
 */
public class Users {

    private List<User> userList;

    /**
     * method to retrieve userList
     * @return 
     */
    public List<User> getuserList() {
        return userList;
    }

    /**
     * method to set UserList
     * @param userList 
     */
    public void setuserList(List<User> userList) {
        this.userList = userList;
    }

}
