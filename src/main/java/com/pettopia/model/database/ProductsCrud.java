/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pettopia.model.bean.Product;
import com.pettopia.model.bean.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ahmedelgawesh
 */
public class ProductsCrud {

    Database dbClass;
    Connection conn;
    Statement stmt = null;

    public ProductsCrud() {

        try {
            dbClass = Database.getInstance();
            conn = dbClass.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Product> getAll(String statement){
        ArrayList<Product> products = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement); 
            while(rs.next()){
                int id = rs.getInt("productid");
                String name = rs.getString("productname");
                double price = rs.getDouble("productprice");
                String isSold = rs.getString("sold_yn");
                String description = rs.getString("productdescription");
                String category = rs.getString("category");
                products.add(new Product(id,name,price ,isSold , description, category));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public boolean insert(String sqlStatment) {
        try {
            stmt = conn.createStatement();
            System.out.println(sqlStatment);
            stmt.executeUpdate(sqlStatment);
            System.out.println("Record saved");
        } catch (SQLException ex) {
            Logger.getLogger(UsersCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

    public boolean delete(String sqlStatment) {
        try {
            //Create statement
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStatment);
            System.out.println("Records deleted");
        } catch (SQLException e) {
            System.out.println("com.pettopia.model.database.UsersCrud.delete()" + e);
            return false;
        }
        return true;
    }

    public boolean update(String sqlStatment) {

        try {
            //Create statement(update)
            stmt = conn.createStatement();
           System.out.println(sqlStatment);
            stmt.executeUpdate(sqlStatment);
            System.out.println("Records updated");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public ArrayList<Product> select(String sqlStatment) {

        ArrayList<Product> productsList = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStatment);
            while (rs.next()) {
                productsList.add(new Product(rs.getInt("productid"),rs.getString("productname"), rs.getDouble("productprice"), rs.getString("sold_yn"), rs.getString("productdescription"), rs.getString("category")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminsCrud.class.getName()).log(Level.SEVERE, null, ex);

        }
        return productsList;
    }

    
    
    
    
    public Product select(String sqlStatment,String dontUse) {

        Product produstObj= new Product();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStatment);
            while (rs.next()) {
                produstObj.setId(rs.getInt("productid"));
                produstObj.setName(rs.getString("productname"));
                produstObj.setPrice(rs.getDouble("productprice"));
                produstObj.setQuantity(rs.getString("sold_yn"));
                produstObj.setCategory(rs.getString("category"));
                produstObj.setDescription(rs.getString("productdescription"));
           
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminsCrud.class.getName()).log(Level.SEVERE, null, ex);

        }
        return produstObj;
    }
    
    public int getLast (String s)
    {
        int result = 0;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s);
            while(rs.next())
            {
             result=rs.getInt(1);
             
            }
        } catch (SQLException ex) {
         
            result = -1;
        }
        return result;
    }

    
    
}
