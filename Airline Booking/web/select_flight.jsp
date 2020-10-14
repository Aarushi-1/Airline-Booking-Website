<%-- 
    Document   : select_flight
    Created on : 24 Oct, 2019, 10:51:55 PM
    Author     : Aarushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" /> 
        <h1>You selected the flight! Wow ready to fly!</h1>
        
        <jsp:useBean id="b" class="booking.bean_booking"/>
        
        <jsp:setProperty name="b" property="*"/>  
        <br><br>
        You entered: <BR><br>
        ID: <%= b.getId()%><BR>
        Airline Name: <%= b.getFirst()%><BR>
        Price: <%= b.getLast()%><BR>
        <br>
        <br>
        <b>Total Amount to be  paid. <%= b.getLast()%></b>
        <br><br>
        <form action="choose_seat.jsp" method="GET">
            <input type="hidden" name="first" value=" <%= b.getFirst()%>">
            <input type="hidden" name="last" value=" <%= b.getLast()%>">
            <input type="hidden" name="id" value=" <%= b.getId()%>">
            <input type="submit" value="Proceed to select seat">
        </form>
        
        
        
    </body>
</html>
