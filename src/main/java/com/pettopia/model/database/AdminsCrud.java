/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.database;

/**
 *
 * @author ahmedelgawesh
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.pettopia.model.bean.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminsCrud {

    Database dbClass;
    Connection conn;
    Statement stmt = null;

    public AdminsCrud() {

        try {
            dbClass = Database.getInstance();
            conn = dbClass.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ************ select all admins the admin table ***********************
     */
    public boolean select(String strStatement) {
        int count = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strStatement);
            while (rs.next()) {
                count++;
            }
        } catch (SQLException ex) {
            System.out.println("com.pettopia.model.database.UsersCrud.select()");
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * ************ select all admins the admin table ***********************
     */
    public boolean insert(String strStatement) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(strStatement);
            System.out.println("Record saved");

        } catch (SQLException ex) {
            Logger.getLogger(AdminsCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    /******************* select specific admin with his data *************************/
public User select(String strStatement,String overload) {
        int counter=0;
             User usr = new User();

        try {                      

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strStatement);
            while (rs.next()) {
                  counter++;
                usr.setEmail(rs.getString("adminemail"));
                usr.setPassword(rs.getString("adminpassword"));

            }
            if(counter <=0 )
                usr.setEmail("");

        } catch (SQLException ex) {
            Logger.getLogger(AdminsCrud.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return usr;
      
    }
    
}
