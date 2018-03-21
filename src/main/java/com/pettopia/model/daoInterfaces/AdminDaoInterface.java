/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.daoInterfaces;

import com.pettopia.model.bean.User;
import java.util.ArrayList;

/**
 *
 * @author ahmedelgawesh
 */
public interface AdminDaoInterface {

    boolean  isExisAsAdmin(User adminEmail);

    public boolean addNewAdmin(String adminEmail, String adminPassword);
    
   User getAllAdmins(String adminEmail);


}
