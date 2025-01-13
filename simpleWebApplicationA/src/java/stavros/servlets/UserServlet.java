/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package stavros.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import stavros.netbean.*;

import stavros.util.*;
import stavros.datas.*;


/**
 *
 * @author Basileiou
 */
public class UserServlet extends HttpServlet {
     private static final String defaultURL = "index.jsp";
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String requestURI = request.getRequestURI();
        String url = "";
        if (requestURI.endsWith("/displayAll")){  
    
           url = displayUsers(request, response);
           
        }else if(requestURI.endsWith("/displayOne")){  
    
          url = displayUser(request, response);
        }
         
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String requestURI = request.getRequestURI();
        String url = "";
        if (requestURI.endsWith("/addUser")) {
            url = addUser(request, response);
            
        }
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
    }
 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    private String addUser(HttpServletRequest request,
            HttpServletResponse response) {
            String message = "";
           // get parameters from the request
            String firstName = request.getParameter("name");
            String surName = request.getParameter("surName");
            String email = request.getParameter("email");         
            String gender = request.getParameter("gender");                  
            String datePick = request.getParameter("datePick"); 
            String workAddress = request.getParameter("workAddress"); 
            String homeAddress = request.getParameter("homeAddress"); 
                 
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
          
            if (user == null) {
                user = new User();
               
            }
            
            if (UserDB.emailExists(email)) {
                
                user = UserDB.selectUser(email);
                user.setFirstName(firstName);
                user.setSurName(surName);
                user.setEmail(email);
                user.setGender(gender);
                user.setDatePick(datePick);              
                UserDB.update(user);
            }else{
                user.setFirstName(firstName);
                user.setSurName(surName);
                user.setEmail(email);
                user.setGender(gender);
                user.setDatePick(datePick);
                UserDB.insert(user);    
            }
              System.out.println("yparxerer" +user.getUserId());
            Address address =  new Address();
            address.findSetAddress(workAddress, homeAddress);
            if(address.getAdrressForDB())
            {
                address.setUser(user);
                  System.out.println("yparxerer" +user.getUserId());
                address.setWorkAddress(workAddress);
                address.setHomeAddress(homeAddress);
                AddressDB.insert(address);
            }
            // store data in User object and save User object in database  
                     
            message = "It 's work... why?";
            // set User object in request object and set URL
            request.setAttribute("message", message);
            request.setAttribute("user", user);
            request.setAttribute("address", address);
            
            session.setAttribute("user", user);
            
            //if i want to romeve object
            //session.removeAttribute("user");
            
            return "/reg/thanks.jsp"; 
         }
    

    private String displayUsers(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        System.out.println("mphka9");
        
        List<User> userTable = UserDB.selectUsers();
        for(User x: userTable)
        {
            if(!x.getaddressList().isEmpty()){
            System.out.println(x.getaddressList().get(0).getWorkAddress());
            }
        }
        String url;
        if (userTable != null) {
            if (userTable.size() <= 0) {
                userTable = null;
            }
        }
       
        HttpSession session = request.getSession();
        session.setAttribute("userTable", userTable);
        url = "/display";
        return url;
    }
    
    private String displayUser(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
         
        HttpSession session = request.getSession();
        String userIdIndexString = request.getParameter("invoiceNumber");
        int userIdIndex = (int) Long.parseLong(userIdIndexString);
        
        System.out.println(userIdIndex);
        List<User> userTable = (List<User>) 
                session.getAttribute("userTable");

        User userOne = null;
        for (User userIndex : userTable ) {
            userOne = userIndex;
            if (userOne.getUserId() == userIdIndex) {
                System.out.println("to vrhka");
                System.out.println(userOne.getFirstName());
                break;
            }
        }

        session.setAttribute("userOne", userOne);

         return "/display/displayOne.jsp";
    }
}
