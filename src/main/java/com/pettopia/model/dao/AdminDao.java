/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.dao;

import com.pettopia.model.bean.User;
import java.util.ArrayList;
import com.pettopia.model.daoInterfaces.AdminDaoInterface;
import com.pettopia.model.factories.SessionsFactory;
import org.hibernate.Session;

/**
 *
 * @author ahmedelgawesh
 */
public class AdminDao implements AdminDaoInterface {

    //hint:we use session per Dao model
    private static Session session = SessionsFactory.getSession();

    @Override
    public boolean isExisAsAdmin(User adminEmail) {
//        String statm = "select * from petadmin where adminemail='" + adminEmail + "'";
//        return adminCrud.select(statm);
          return false;

    }

    @Override
    public boolean addNewAdmin(String adminEmail, String adminPassword) {
//        String statm = "insert into  petadmin (adminemail,adminpassword) VALUES ('" + adminEmail + "','" + adminPassword + "')";
//        return adminCrud.insert(statm);
return false;
    }
    
     @Override
    public User getAllAdmins(String adminEmail) {
//        String statm = "select * from petadmin where adminemail='" + adminEmail + "'";
//        return adminCrud.select(statm,"");
return null;
    }

}
