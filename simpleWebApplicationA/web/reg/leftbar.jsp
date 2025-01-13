<%-- 
    Document   : leftbar
    Created on : 3 ???? 2023, 3:06:35??.?.
    Author     : Basileiou
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <nav>
        <ul>    
            <li><a href="<c:url value='/' />">Home</a></li>
            <li><a  class="active" href="<c:url value='/reg' />"> Register New User</a></li>
            <li><a href="<c:url value='/userServlet/displayAll' />">Display Users</a></li>
        </ul> 
    </nav>
</aside>
