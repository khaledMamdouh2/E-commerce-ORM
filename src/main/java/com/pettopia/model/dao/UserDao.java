/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.dao;

import com.pettopia.model.bean.User;
import java.time.LocalDate;
import java.util.ArrayList;
import com.pettopia.model.daoInterfaces.UserDaoInterface;
import com.pettopia.model.factories.SessionsFactory;
import org.hibernate.Session;

/**
 *
 * @author Passant
 */
public class UserDao implements UserDaoInterface {

    //hint:we use session per Dao model
    private static Session session = SessionsFactory.getSession();
    
    public UserDao() {
    }

    @Override
    public ArrayList<User> selectAllUsers(String usrEmail) {
//        String selectStatement = "select  * from petusers where  useremail= '" + usrEmail + "'";
//        return  usersCrud.select(selectStatement);
return null;
    }

    @Override
    public User selectUser(String usrEmail) {
// String selectStatement = "select  * from petusers where  useremail= '" + usrEmail + "'";
//        return  usersCrud.select(selectStatement,"onlyone");
return null;

    }

    @Override
    public boolean isUserExist(String usrEmail) {
//   String selectStatement = "select userid, userfName, userlName, userbirthDate, userpassword, userjob, useremail, useraddress, usercreditLimit, usercreditnumber from petusers where  useremail= '" + usrEmail + "'";
//        return  usersCrud.select(selectStatement,"","");
return false;
    }
    
    
    
    

    @Override
    public boolean registerNewUser(User usrDataObj) {
//        System.out.println(String.valueOf(java.sql.Date.valueOf(usrDataObj.getBirthDate())));
//        String selectStatment = "insert into petusers (userfName,userlName,userbirthDate,userpassword,userjob,useremail,useraddress,usercreditLimit,usercreditNumber) values ('" + usrDataObj.getFirstName() + "' ,'" + usrDataObj.getLastName() + "' , TO_DATE('"+usrDataObj.getBirthDate()+"','YYYY-MM-DD'),'" + usrDataObj.getPassword() + "' ,'" + usrDataObj.getJob() + "' ,'" + usrDataObj.getEmail() + "' ,'" + usrDataObj.getAddress() + "' ," + usrDataObj.getCreditLimit() + "," + usrDataObj.getCreditNo() + ")";
//        return usersCrud.insert(selectStatment);
return false;
    }

    @Override
    public boolean updateUser(User usrDataObj) {
//        String selectStatment = "update petusers set userfName='" + usrDataObj.getFirstName() + "' ,userlName='" + usrDataObj.getLastName() + "' ,userbirthDate= TO_DATE('"+usrDataObj.getBirthDate()+"','YYYY-MM-DD'), userpassword='" + usrDataObj.getPassword() + "' ,userjob='" + usrDataObj.getJob() + "' ,useraddress='" + usrDataObj.getAddress() + "' ,usercreditlimit=" + usrDataObj.getCreditLimit() + " ,usercreditnumber='" + usrDataObj.getCreditNo() + "' where useremail ='" + usrDataObj.getEmail()+"'";
//        return usersCrud.update(selectStatment);
return false;
    }

}
