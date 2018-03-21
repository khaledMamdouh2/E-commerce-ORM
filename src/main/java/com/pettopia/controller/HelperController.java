/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.controller;

import com.pettopia.model.bean.User;
import com.pettopia.model.dao.UserDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Passant
 */
public class HelperController {

    private User user;
    private UserDao userDao;

    public HelperController() {
        userDao = new UserDao();
        user = new User();
    }

    public void setUser(List<String> data) {

        user.setUserfname(data.get(0));
        user.setUserlname(data.get(1));
        user.setUseremail(data.get(2));
        user.setUserpassword(data.get(3));
        user.setUserjob(data.get(4));
        user.setUseraddress(data.get(5));
        user.setUsercreditnumber(Long.parseLong(data.get(6)));
        user.setUsercreditlimit(Long.parseLong(data.get(7)));
        user.setUserbirthdate(java.sql.Date.valueOf(LocalDate.parse(data.get(8))));
    }

    public List<String> getUser(String email) {
        List<String> data = new ArrayList<>();

        data.add(user.getUserfname());
        data.add(user.getUserlname());
        data.add(user.getUseremail());
        data.add(user.getUserpassword());
        data.add(user.getUserjob());
        data.add(user.getUseraddress());
        data.add(String.valueOf(user.getUsercreditnumber()));
        data.add(String.valueOf(user.getUsercreditlimit()));
        data.add(user.getUserbirthdate().toString());

        return data;
    }

    public boolean register(List<String> userData) {
        boolean isRegistered = false;
        if (!userDao.isUserExist(userData.get(2))) {
            setUser(userData);
            if (userDao.registerNewUser(user)) {
                isRegistered = true;
            }
        }
        return isRegistered;
    }

    public boolean login(String email, String pass) {
        boolean isLoggedIn = false;
        if (userDao.isUserExist(email)) {
            user = userDao.selectUser(email);
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

}
