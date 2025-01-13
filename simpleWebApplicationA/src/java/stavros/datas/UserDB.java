/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stavros.datas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import stavros.netbean.*;
import stavros.datas.*;

public class UserDB {

    public static void insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query
                = "INSERT INTO Userinfo (FirstName, LastName, Gender, Birthdate, Email) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSurName());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getDatePick());
            ps.setString(5, user.getEmail());
            
            ps.executeUpdate();
           
            //Get the user ID from the last INSERT statement.
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            long userId = identityResultSet.getLong("IDENTITY");
            identityResultSet.close();
            identityStatement.close();
            // Set the user ID in the User object
            user.setUserId(userId);
 
            System.out.println("userId"+user.getUserId());
        } catch (SQLException e) {
            System.out.println(e);
     
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE Userinfo SET "
                + "FirstName = ?, "
                + "LastName = ?, "
                + "Gender = ?, "
                + "Birthdate = ? "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSurName());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getDatePick());
            ps.setString(5, user.getEmail());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM Userinfo "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM Userinfo "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Userinfo "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getLong("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setSurName(rs.getString("LastName"));
                user.setGender(rs.getString("Gender"));
                user.setDatePick(rs.getString("Birthdate"));
                user.setEmail(rs.getString("Email"));
                
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    //This method returns null if a user isn't found.
    public static ArrayList<User> selectUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Userinfo ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();     
            ArrayList<User> users = new ArrayList<>(); 
            while (rs.next()) {
               
                List<Address> addressIndex = AddressDB.selectAddressIndexs(rs.getLong("UserID"));
                User user = new User();
                user.setUserId(rs.getLong("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setSurName(rs.getString("LastName"));
                user.setGender(rs.getString("Gender"));
                user.setDatePick(rs.getString("Birthdate"));
                user.setEmail(rs.getString("Email"));
                user.setaddressList(addressIndex);
                users.add(user);
            }
            
            return users;
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