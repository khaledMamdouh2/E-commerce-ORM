/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.controller;

import com.pettopia.model.database.UserDao;
import com.pettopia.model.bean.User;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Passant
 */
public class UserController {

    private User user;
    private UserDao userDao;

    public UserController() {
        userDao = new UserDao();
        user = new User();
    }

    public void update(List<String> data) {

        user.setFirstName(data.get(0));
        user.setLastName(data.get(1));
        user.setEmail(data.get(2));
        user.setPassword(data.get(3));
        user.setJob(data.get(4));
        user.setAddress(data.get(5));
        user.setCreditNo(Long.parseLong(data.get(6)));
        user.setCreditLimit(Long.parseLong(data.get(7)));
        user.setBirthDate(LocalDate.parse(data.get(8)));
        
        updateCurrentUser();
    }
    
    private void updateCurrentUser(){
        if(userDao.updateUser(user)){
            System.out.println("updated");
        } else{
            System.out.println("Cannot Update");
        }
    }

}
