/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stavros.netbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Basileiou
 */

public class User implements Serializable {
  
    private Long userId;
    private String firstName;
    private String surName;
    private String email;
    private String gender;
    private String datePick;  
     private List<Address> addressList;

    public User() {       
        firstName = "";
        surName = "";
        email = "";
        gender = "";
        datePick = "";
              
    }
  

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     
    public String getEmail() {
        return email;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
     
    public String getGender() {
        return gender;
    }
    
    public String getDatePick() {
        return datePick;
    }

    public void setDatePick(String datePick) {
        this.datePick = datePick;
    }

    public void setaddressList(List<Address> addressList ) {
        this.addressList = addressList;
    }

    public List<Address> getaddressList() {
        return addressList;
    }
       
}
