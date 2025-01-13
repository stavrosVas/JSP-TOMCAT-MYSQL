<%-- 
    Document   : index
    Created on : 2 Ιουν 2023, 8:56:58 π.μ.
    Author     : Basileiou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP-TOMCAT-MYSQL</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
        
    </head>
    <body>
        <div class="header">
            <h2>JSP - TOMCAT - MYSQL</h2>
            <h4> Home </h4>
        </div>
        <div class="flex">
        <div class="side" >          
        <ul>    
          <li><a class="active" href="<c:url value='/' />">Home</a></li>
          <li><a href="<c:url value='/reg' />"> Register New User</a></li>
          <li><a href="<c:url value='/userServlet/displayAll' />">Display Users</a></li>
        </ul>               
      </div>
        <div class="main" >
        
         <h1>What time is it?</h1>

         <p><i>${message}</i></p>
       </div>

       <div class="side" >
           <img src="<c:url value='/images/meme.jpg' />" alt="Meme" width="220" >
       </div>
    </div>
    <jsp:include page="/includes/footer.jsp" />
 

