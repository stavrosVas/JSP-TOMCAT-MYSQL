<%-- 
    Document   : index
    Created on : 3 ???? 2023, 2:51:46??.?.
    Author     : Basileiou
--%>

 <jsp:include page="/reg/header.jsp" />
 <jsp:include page="/reg/leftbar.jsp" />
 
<section class="cart">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Enter your name and contact information</h2>

<form action="<c:url value='/userServlet/addUser' />" method=post>
    <input type="hidden" name="action" value="add">  
    <p id="required">Required <span class="required">*</span></p>
    
    <label>Name</label>
    <input type="text" name="name"  maxlength=20 
               value="${user.firstName}" required>
    <p class="required">*</p><br>
    
    <label>Surname</label>
    <input type="text" name="surName" value="${user.surName}" required>
    <p class="required">*</p><br>
    
    <label>Email Address</label>
    <input type="email" name="email" value="${user.email}" required>
    <p class="required">*</p><br>
    
    <label>Gender:</label>
    <select type="text" name="gender" value=" ${user.datePick}" required >
    <option value="none">None</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    </select>
    <p class="required">*</p><br>
   
    <label>BirthDate</label>
    <input type="date" name="datePick" value="${user.datePick}" required>
    <p class="required">*</p><br>  
    
    <label>Work Adress</label>
    <input type="text" name="workAddress" value="${address.workAddress}"> 
    <p class="required">&nbsp;</p><br>
    
    <label>Home Adrress</label>
    <input type="text" name="homeAddress" value="${address.homeAddress}">
    <p class="required">&nbsp;</p><br>
    

    <label>&nbsp;</label>
    <input type="submit" value="Sudmit">
</form>
    
</section>
<jsp:include page="/reg/rightbar.jsp" />
<jsp:include page="/includes/footer.jsp" />

