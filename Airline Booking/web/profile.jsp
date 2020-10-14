<%-- 
    Document   : profile
    Created on : 5 Nov, 2019, 12:53:30 AM
    Author     : Aarushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <jsp:include page="header.jsp" /> <br>
        <h1>Profile Section</h1>
        
        <% String n = (String)session.getAttribute("currentSessionUser"); 
        out.println("Hello " + n); %><br>
        
        You have no discounts. please come back for more!
    </body>
</html>
