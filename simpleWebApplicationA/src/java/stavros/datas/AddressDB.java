/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stavros.datas;

/**
 *
 * @author Basileiou
 */


import java.sql.*;
import java.util.*;

import stavros.netbean.*;


public class AddressDB {
    
    public static void insert( Address address) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "INSERT INTO Address (UserID, WorkAddress, HomeAddress) "
                + "VALUES (?, ?, ?)";
        try {
            
            
            ps = connection.prepareStatement(query);
            ps.setLong(1, address.getUser().getUserId());
            ps.setString(2, address.getWorkAddress());
            ps.setString(3, address.getHomeAddress());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
             DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
     //This method returns null if a record isn't found.
    public static List<Address> selectAddressIndexs(long userID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Address "
                + "WHERE UserID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, userID);
            rs = ps.executeQuery();
            List<Address> addressList = new ArrayList<>();
            while (rs.next()) {
                Address address = new Address();
 
                address.setWorkAddress(rs.getString("WorkAddress"));
                address.setHomeAddress(rs.getString("HomeAddress"));
                addressList.add(address);
            }
            return addressList;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
 
}
