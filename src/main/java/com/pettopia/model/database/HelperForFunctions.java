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
public class HelperForFunctions {

    /*
    
    
            String selectStatement = "select id,name,username,email,password,gender,country,birthdate,userpicture,statusflag,statusmode from User where id= '"+usrInformation+"' or username= '"+usrInformation+"'";
            String sqlStatm= "INSERT INTO Friend (user_id,friend_id,requestflag) VALUES ('"+myId+"','"+userId+"',0)";
            String sqlStatm = "update Friend set requestflag = 1 where (user_id,friend_id) = ('"+myId+"','"+userId+"')";
            String sqlStatm = "delete  from Friend  where (user_id,friend_id) =  ('"+myId+"','"+userId+"')";

    
    
    
    

    

    
    public  boolean update (String sqlStatm)
    {

      
    
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strStatement);
            while (rs.next())
            {
                        //int id,String name,String username,String email,String password,boolean gender,String country,LocalDate birthdate,String userPic,boolean status,String mode
                        clients.add(new beans.User(rs.getInt("id"),rs.getString("name"),rs.getString("username"),
                        rs.getString("email"),rs.getString("password"),rs.getBoolean("gender"),
                        rs.getString("country"),utilities.SqlParser.fromSqlToLocalDate(rs.getDate("birthdate")),
                        rs.getString("userPicture"),rs.getBoolean("statusFlag"),rs.getString("statusMode")));
            }
    
    
    
    
    public int  select(String strStatement,int x)
        {    
            try
            {   
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(strStatement);
                while (rs.next())
                {
                    int id= rs.getInt("id");
                    System.out.println(id);
                    return id;
                }
    
    
    
    
    public  boolean delete (String sqlStatm)
    {
        try
        {
            //Create statement
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStatm);
            System.out.println("Records deleted");
        }
    
    
    
     */
}
