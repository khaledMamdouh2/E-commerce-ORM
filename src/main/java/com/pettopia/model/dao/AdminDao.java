/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.dao;

import com.pettopia.model.bean.Petadmin;
import com.pettopia.model.bean.User;
import java.util.ArrayList;
import java.util.List;

import com.pettopia.model.daoInterfaces.AdminDaoInterface;
import com.pettopia.model.factories.SessionsFactory;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ahmedelgawesh
 */
public class AdminDao implements AdminDaoInterface {

    //hint:we use session per Dao model
    private static Session session = SessionsFactory.getSession();

    /* (non-Javadoc)
     * @see com.pettopia.model.daoInterfaces.AdminDaoInterface#isExisAsAdmin(com.pettopia.model.bean.User)
     */
    @Override
    public boolean isExisAsAdmin(User adminEmail) {
//        String statm = "select * from petadmin where adminemail='" + adminEmail + "'";
//        return adminCrud.select(statm);

        if (!adminEmail.getUseremail().equals("")) {
            String query = "from Petadmin p where p.adminemail like :email";
            Query q = session.createQuery(query).setString("email", adminEmail.getUseremail());
            List result = q.list();
            System.out.println(result);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addNewAdmin(String adminEmail, String adminPassword) {
//        String statm = "insert into  petadmin (adminemail,adminpassword) VALUES ('" + adminEmail + "','" + adminPassword + "')";
//        return adminCrud.insert(statm);

        if (!(adminEmail.equals("") && adminPassword.equals(""))) {
            Petadmin newAdmin = new Petadmin(adminEmail, adminPassword);
            session.beginTransaction();
            session.persist(newAdmin);
            session.getTransaction().commit();
            System.out.println("new admin is added with data" + adminEmail + "," + adminPassword);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getAllAdmins(String adminEmail) {
//        String statm = "select * from petadmin where adminemail='" + adminEmail + "'";
//        return adminCrud.select(statm,"");

        if (!adminEmail.equals("")) {
            String query = "from Petadmin p where p.adminemail like :email";
            Query q = session.createQuery(query).setString("email", adminEmail);
            List result = q.list();
            System.out.println(result);
            if (result != null && result.size()>0) {
                Petadmin admin = (Petadmin) result.get(0);
                User u = new User();
                u.setUseremail(admin.getAdminemail());
                u.setUserpassword(admin.getAdminpassword());

                return u;
            } 
                
        }
        return null;
    }
}
