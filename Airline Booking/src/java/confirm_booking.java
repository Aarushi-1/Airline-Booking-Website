/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import booking.bean_booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Aarushi
 */
public class confirm_booking extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //bean_booking b= new bean_booking();
            //out.println(b.getId()+b.getFirst()+b.getLast()+b.getSeat_no()+b.getFood()+b.getTotal());
            String first=request.getParameter("first");
            String last=request.getParameter("last");
            String id=request.getParameter("id");
            String seatno=request.getParameter("seatno");
            String food=request.getParameter("food");
            
            
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DEMO", "aaru321");
                //Statement stm =con.createStatement();
                String s1="insert into AMITY_TABLES.BOOK1";
                PreparedStatement stmt=con.prepareStatement("insert into AMITY_TABLES.BOOK1 values(?,?,?,?,?)");  
                stmt.setString(1,id);
                stmt.setString(2,first);
                stmt.setString(3,last);
                stmt.setString(4,seatno);
                stmt.setString(5,food);
                int i= stmt.executeUpdate(); 
                //out.println(i);
                
            //response.sendRedirect("confirm_booking.jsp");
                
                 }
            catch(Exception e){
                    System.out.println(e);
           }
            
            out.print("<form action='confirm_booking.jsp'>");  
            out.print("<input type='hidden' name='first' value='"+first+"'>");
            out.print("<input type='hidden' name='last' value='"+last+"'>"); 
            out.print("<input type='hidden' name='id' value='"+id+"'>"); 
            out.print("<input type='hidden' name='seatno' value='"+seatno+"'>");
            out.print("<input type='hidden' name='food' value='"+food+"'>"); 
            out.println("Are you sure you want to continue ?? Please click below :");
            out.print("<input type='submit' value='Confirm And go'>");  
            out.print("</form>");  
            
            //response.sendRedirect("confirm_booking.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
