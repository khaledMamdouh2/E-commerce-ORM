/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.databaseInterfaces;

import com.pettopia.model.bean.User;
import java.util.ArrayList;

/**
 *
 * @author ahmedelgawesh
 */
public interface UsersDatabaseOperationInterface {

    public ArrayList<User> selectAllUsers(String usrEmail);
    
        public User selectUser(String usrEmail);


    public boolean registerNewUser(User usrDataObj);

    public boolean updateUser(User usrDataObj);
    
    public boolean isUserExist(String usrEmail);

}
