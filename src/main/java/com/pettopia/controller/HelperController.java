/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.controller;

import com.pettopia.model.bean.User;
import com.pettopia.model.database.UserDao;
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

        user.setFirstName(data.get(0));
        user.setLastName(data.get(1));
        user.setEmail(data.get(2));
        user.setPassword(data.get(3));
        user.setJob(data.get(4));
        user.setAddress(data.get(5));
        user.setCreditNo(Long.parseLong(data.get(6)));
        user.setCreditLimit(Long.parseLong(data.get(7)));
        user.setBirthDate(LocalDate.parse(data.get(8)));
    }

    public List<String> getUser(String email) {
        List<String> data = new ArrayList<>();

        data.add(user.getFirstName());
        data.add(user.getLastName());
        data.add(user.getEmail());
        data.add(user.getPassword());
        data.add(user.getJob());
        data.add(user.getAddress());
        data.add(String.valueOf(user.getCreditNo()));
        data.add(String.valueOf(user.getCreditLimit()));
        data.add(user.getBirthDate().toString());

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
