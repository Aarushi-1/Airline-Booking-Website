<%-- 
    Document   : choose_seat
    Created on : 24 Oct, 2019, 10:52:14 PM
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
        <br>
        <% String n = (String)session.getAttribute("currentSessionUser"); 
        out.println("Hello " + n);
        
        String n1 = (String)session.getAttribute("seatno"); 
        
        
        String n2 = (String)session.getAttribute("food"); 
        
        String n3 = (String) session.getAttribute("id"); 
       
        String n4 = (String)session.getAttribute("first"); 
        
        String n5 = (String)session.getAttribute("last"); 
        
        %>
        
        
        <%  String first=request.getParameter("first");
            String last=request.getParameter("last");
            String id=request.getParameter("id");
            String seatno=request.getParameter("seatno");
            String food=request.getParameter("food");
              
         %>
        <h1 style="background-color: lightgreen">CONFIRMED! Enjoy your flight!</h1>
        <h4 style="color: cadetblue"> Thank You for booking with us! ! You are good to go!</h4>
        
        
        <jsp:useBean id="b" class="booking.bean_booking"/>
        
        
        <br><br>
        <h3>Your flight details are: </h3><BR><br>
        <b>Name of the person: <%=n%></b><br>
        Flight ID: <%= id%> <BR>
        Airline Name: <%= first%><BR>
        Price: <%= last%><BR><br>
        Add-ons:<br><br>
        Seat Choice: <%= seatno%><br>
        Food option: <%= food%><br><br><br>
        <b>Total Amount: <%= last%></b>
        <br>
        
    </body>
</html>
