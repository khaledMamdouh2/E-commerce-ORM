/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pettopia.model.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;

/**
 *
 * @author Passant
 */
public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String password;
    private String job;
    private String email;
    private String address;
    private long creditLimit;
    private long creditNo;
    
        /********* sobhy (start)**********/
    
    public User(){}
    
     public  User(int id, String firstName, String lastName, LocalDate birthDate, String password,String job,String email, String address,int creditLimit, int creditNo)
      {
      this.id= id;
      this.firstName=firstName;
      this.lastName=lastName;
      this.birthDate=birthDate;
      this.password=password;
      this.job=job;
      this.email=email;
      this.address=address;
      this.creditLimit=creditLimit;
      this.creditNo=creditNo;
    }
    
    public  User(String adminEmail,String adminPassword)
    {
        
        this.email = adminEmail;
        this.password= adminPassword;
    
    }
    
    
    /********* sobhy (end)**********/
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public long getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(long creditNo) {
        this.creditNo = creditNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
