<%-- 
    Document   : thanks
    Created on : 4 ???? 2023, 12:04:09??.?.
    Author     : Basileiou
--%>

 <jsp:include page="/reg/header.jsp" />
 <jsp:include page="/reg/leftbar.jsp" />
 
<section class="cart">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Thanks for joining</h2>
<p>Here is the information that you entered:</p>
<p></p>
    <label>Name</label>
    <span>${user.firstName}</span><br>
            
    <label>Surname</label>
    <span> ${user.surName}</span><br>
    
    <label>Email Address</label>
    <span>${user.email}</span><br>
        
    <label>Gender</label>
    <span>${user.gender}</span><br>
 
    <label>BirthDate</label>
    <span>${user.datePick}</span><br>
         
    <label>Work Adress</label>
    <span>${address.workAddress}</span><br>
        
    <label>Home Adrress</label>
    <span>${address.homeAddress}</span><br>
           
</section>
    
<jsp:include page="/reg/rightbar.jsp" />
<jsp:include page="/includes/footer.jsp" />
