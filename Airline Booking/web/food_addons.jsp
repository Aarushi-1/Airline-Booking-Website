<%-- 
    Document   : food_addons
    Created on : 24 Oct, 2019, 10:53:46 PM
    Author     : Aarushi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" /> 
        
        <% 
            String n = request.getParameter("seatno"); 
            
            
            String a=request.getParameter("first");
            String b=request.getParameter("last");
            String c=request.getParameter("id");
        %>
        
        
        
                         
        
        <h2 style="background-color: lightgreen">Congrats! We wont let anyone sit on seat no : <%= n%></h2><br> 
        Your flight details:<br><br>
        ID:<%= c%><br>
        Airline Name:<%= a%><br>
        Price:<%= b%><br>
        <b>Add-ons:</b><br>
        Seat no Preference: <%=n%>
        <h1>Choose food!</h1>
        <div>
            <br>
            
            <form action="confirm_booking">
                
                <input type="radio" name="food" value="Tea & Coffee"> Tea & Coffee<br>
                <input type="radio" name="food" value="Veg Thali"> Veg Thali<br>
                <input type="radio" name="food" value="Italian Combo"> Italian Combo<br>
                <input type="radio" name="food" value="Contiental Plate" checked> Contiental Plate<br><br>
                
                <input type="hidden" name="first" value="<%=a %>">
                <input type="hidden" name="last" value="<%=b %>">
                <input type="hidden" name="id" value="<%=c %>">
                <input type="hidden" name="seatno" value="<%= n%>">
                <input type="submit" value="Proceed">
            </form><br>
        </div>
        
    </body>
</html>
