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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

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
        if (!usrEmail.equals("")) {
            List<User> listofusers;

            String query = "from petusers u where u.useremail like :email";
            Query q = session.createQuery(query).setString("email", usrEmail);
            listofusers = (List<User>) q.list();
            return (ArrayList<User>) listofusers;
        } else {
            return null;

        }
    }

    @Override
    public User selectUser(String usrEmail) {
// String selectStatement = "select  * from petusers where  useremail= '" + usrEmail + "'";
//        return  usersCrud.select(selectStatement,"onlyone");

        if (!usrEmail.equals("")) {
            String query = "from petusers u where u.useremail like :email";
            Query q = session.createQuery(query).setString("email", usrEmail);
            List result = q.list();
            System.out.println(result);

            User user = (User) result.get(0);

            return user;
        } else {
            return null;
        }

    }

    @Override
    public boolean isUserExist(String usrEmail) {
//   String selectStatement = "select userid, userfName, userlName, userbirthDate, userpassword, userjob, useremail, useraddress, usercreditLimit, usercreditnumber from petusers where  useremail= '" + usrEmail + "'";
//        return  usersCrud.select(selectStatement,"","");
        if (!usrEmail.equals("")) {
            String query = "from petusers u where u.useremail like :email";
            Query q = session.createQuery(query).setString("email", usrEmail);
            List result = q.list();
            System.out.println(result);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean registerNewUser(User usrDataObj) {
//        System.out.println(String.valueOf(java.sql.Date.valueOf(usrDataObj.getBirthDate())));
//        String selectStatment = "insert into petusers (userfName,userlName,userbirthDate,userpassword,userjob,useremail,useraddress,usercreditLimit,usercreditNumber) values ('" + usrDataObj.getFirstName() + "' ,'" + usrDataObj.getLastName() + "' , TO_DATE('"+usrDataObj.getBirthDate()+"','YYYY-MM-DD'),'" + usrDataObj.getPassword() + "' ,'" + usrDataObj.getJob() + "' ,'" + usrDataObj.getEmail() + "' ,'" + usrDataObj.getAddress() + "' ," + usrDataObj.getCreditLimit() + "," + usrDataObj.getCreditNo() + ")";
//        return usersCrud.insert(selectStatment);
        if (!(usrDataObj.getUserbirthdate().equals("")
                && usrDataObj.getUseraddress().equals("") && usrDataObj.getUsercreditlimit() == 0 && usrDataObj.getUsercreditnumber() == 0
                && usrDataObj.getUseremail().equals("") && usrDataObj.getUserfname().equals("") && usrDataObj.getUserlname().equals("") && usrDataObj.getUserjob().equals("")
                && usrDataObj.getUserpassword().equals(""))) {

            User newuser = new User();

            newuser.setUseraddress(usrDataObj.getUseraddress());
            newuser.setUserbirthdate(usrDataObj.getUserbirthdate());
            newuser.setUsercreditnumber(usrDataObj.getUsercreditlimit());
            newuser.setUsercreditlimit(usrDataObj.getUsercreditlimit());
            newuser.setUseremail(usrDataObj.getUseremail());
            newuser.setUserfname(usrDataObj.getUserfname());
            newuser.setUserpassword(usrDataObj.getUserpassword());
            newuser.setUserjob(usrDataObj.getUserjob());
            newuser.setUserlname(usrDataObj.getUserfname());
            session.beginTransaction();
            session.persist(newuser);
            session.getTransaction().commit();

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean updateUser(User usrDataObj) {
//        String selectStatment = "update petusers set userfName='" + usrDataObj.getFirstName() + "' ,userlName='" + usrDataObj.getLastName() + "' ,userbirthDate= TO_DATE('"+usrDataObj.getBirthDate()+"','YYYY-MM-DD'), userpassword='" + usrDataObj.getPassword() + "' ,userjob='" + usrDataObj.getJob() + "' ,useraddress='" + usrDataObj.getAddress() + "' ,usercreditlimit=" + usrDataObj.getCreditLimit() + " ,usercreditnumber='" + usrDataObj.getCreditNo() + "' where useremail ='" + usrDataObj.getEmail()+"'";
//        return usersCrud.update(selectStatment);

        if (isUserExist(usrDataObj.getUseremail())) {
            User olduser = (User) session.get(User.class, usrDataObj.getUserid());
            User newuser = new User();

            newuser.setUseraddress(olduser.getUseraddress());
            newuser.setUserbirthdate(olduser.getUserbirthdate());
            newuser.setUsercreditnumber(olduser.getUsercreditlimit());
            newuser.setUsercreditlimit(olduser.getUsercreditlimit());
            newuser.setUseremail(olduser.getUseremail());
            newuser.setUserfname(olduser.getUserfname());
            newuser.setUserpassword(olduser.getUserpassword());
            newuser.setUserjob(olduser.getUserjob());
            newuser.setUserlname(olduser.getUserfname());
            session.beginTransaction();
            session.update(newuser);
            session.getTransaction().commit();

            return true;
        } else {
            return false;
        }

    }

}
