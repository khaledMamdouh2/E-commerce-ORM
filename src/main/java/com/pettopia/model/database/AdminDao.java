/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.database;

import com.pettopia.model.bean.User;
import com.pettopia.model.databaseInterfaces.AdminsDatabaseOperationInterface;
import java.util.ArrayList;

/**
 *
 * @author ahmedelgawesh
 */
public class AdminDao implements AdminsDatabaseOperationInterface {

    AdminsCrud adminCrud = new AdminsCrud();

    @Override
    public boolean isExisAsAdmin(User adminEmail) {
        String statm = "select * from petadmin where adminemail='" + adminEmail + "'";
        return adminCrud.select(statm);

    }

    @Override
    public boolean addNewAdmin(String adminEmail, String adminPassword) {
        String statm = "insert into  petadmin (adminemail,adminpassword) VALUES ('" + adminEmail + "','" + adminPassword + "')";
        return adminCrud.insert(statm);

    }
    
     @Override
    public User getAllAdmins(String adminEmail) {
        String statm = "select * from petadmin where adminemail='" + adminEmail + "'";
        return adminCrud.select(statm,"");
    }

}
