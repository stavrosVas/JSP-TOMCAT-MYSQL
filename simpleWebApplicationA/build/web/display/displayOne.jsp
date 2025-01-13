<%-- 
    Document   : displayOne
    Created on : 6 ???? 2023, 3:29:51??.?.
    Author     : Basileiou
--%>

<jsp:include page="/display/header.jsp" />
 <jsp:include page="/display/leftbar.jsp" />
 
 <section class="cart">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h2>Information User</h2>

    <table>  
        <tr>
          <th><b> Name</b></th>
          <th><b>Surname</b></th>
          <th><b>Email</b></th>
         <th><b>Gender</b></th>
         <th><b>DatePick</b></th>
        </tr>
            <tr>  
              <td>${userOne.firstName}</td>
              <td>${userOne.surName}</td>
              <td> ${userOne.email}</td>
              <td> ${userOne.gender}</td>
              <td> ${userOne.datePick}</td>
            </tr>
       <tr>
         
     </table>
          
      <table>
             <th><b> WorkAddress</b></th>
          <th><b>HomeAddress</b></th>
        </tr>
        
           <c:forEach var="item" items="${userOne.addressList}">
            <tr>
              <td>${item.workAddress}</td>
               <td>${item.homeAddress}</td>
              
            </tr>
               </c:forEach>
    
      </table>
</section>

<jsp:include page="/includes/footer.jsp" />
