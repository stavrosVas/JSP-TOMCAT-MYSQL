/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stavros.netbean;

import java.io.Serializable;

/**
 *
 * @author Basileiou
 */
public class Address implements Serializable {
    
  
    private Long adddressId;
    private User user;
    private String workAddress;
    private String homeAddress;
    private boolean addDB;
    
    public Address() {  
        user = null;
        workAddress  = "";
        homeAddress = "";   
        addDB = false;
    }
    
    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
     public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    public void setAdrressForDB(boolean addDB){
        this.addDB = addDB;
    }
    
    public boolean getAdrressForDB()
    {
        return addDB;
    }
    
    public void findSetAddress(String workAddress, String homeAddress )
    {
        boolean flag = false;
        if( !workAddress.isEmpty() ){
            this.setWorkAddress(workAddress);
            flag = true;
        }
        if( !homeAddress.isEmpty() )
        {
            this.setHomeAddress(homeAddress);
            flag = true;
        }
        setAdrressForDB(flag);
    }
    
}
