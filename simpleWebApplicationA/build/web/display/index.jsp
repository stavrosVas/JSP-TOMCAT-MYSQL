<%-- 
    Document   : /display/index
    Created on : 2 ???? 2023, 9:28:07??.?.
    Author     : Basileiou
--%>



 <jsp:include page="/display/header.jsp" />
 <jsp:include page="/display/leftbar.jsp" />
 
 <section class="cart">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <h2>Information Users</h2>

    <table>  
        <tr>
          <th><b> Name</b></th>
          <th><b>Surname</b></th>
          <th><b>UserID</b></th>
         <th><b>Inform</b></th>
        </tr>

        <c:forEach var="usertab" items="${userTable}">
            <tr>  
              <td>${usertab.firstName}</td>
              <td>${usertab.surName}</td>
              <td> ${usertab.userId}</td>
               <td>
                <a href="<c:url value='/userServlet/displayOne?invoiceNumber=${usertab.userId}' /> ">Click to View</a>
              </td>
            </tr>
        </c:forEach>
     </table>
</section>
<jsp:include page="/display/rightbar.jsp" />
<jsp:include page="/includes/footer.jsp" />

 