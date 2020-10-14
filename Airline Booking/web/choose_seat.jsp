<%-- 
    Document   : profile_viewbooking
    Created on : 24 Oct, 2019, 10:59:10 PM
    Author     : Aarushi
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" /> 
        <h1>You Have chosen:</h1>
        ID:
         <% String c=request.getParameter("id");
            out.println(c);
            out.println("<br>"); %>
        Airline Name :   
         <%   String a=request.getParameter("first");
                   out.print(a);
            out.println("<br>");   %>  
        Price:    
         <%   String b=request.getParameter("last");
            out.println(b);
            out.println("<br>"); 
         %>
         
         
        <h1>Please Choose a seat!</h1>
        <p style="background-color: greenyellow" align="middle">FRONT of the plane</p>
        <div style="float: left; margin-left: 250px" margin:250px>
        <%
            int i=0;
            for(i=0;i<=30;i++){ %>
            <form action="food_addons.jsp">
                <input type="hidden" name="first" value="<%=a %>">
                <input type="hidden" name="last" value="<%=b %>">
                <input type="hidden" name="id" value="<%=c %>">
                
               
                
            <table align="justify" border="2">
                <tr>
                    <td><input type="submit" name="seatno" value=<% out.println(i+"A");%>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(i+"b");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(i+"c");
                    %>> </td>
                    <td><input type="submit" name="seatno" value=<% out.println(i+"d");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(i+"e");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(i+"f");
                    %>> </td>
                </tr>
                <% } %>
            </table>   
    </div>
            
            <div style="margin-left: 850px" margin:250px>
            <%    int j=0;
            for(j=0;j<=30;j++){ %>
            <table border="2" style="text-align: center">
                <tr>
                    <td><input type="submit" name="seatno" value=<% out.println(j+"A");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(j+"b");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(j+"c");
                    %>> </td>
                    <td><input type="submit" name="seatno" value=<% out.println(j+"d");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(j+"e");
                    %>> </td>
                
                    <td><input type="submit" name="seatno" value=<% out.println(j+"f");
                    %>> </td>
                </tr>
                <% } %>
            </table>  
            
            <input type="submit" value="Food">
            </form>
            
            </div>
            <p style="background-color: greenyellow" align="middle">REAR of the plane</p>
            <br>
            
    </body>
</html>
