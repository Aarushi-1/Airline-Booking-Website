/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aarushi
 */
public class NewServlet extends HttpServlet {

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
            HttpSession session = request.getSession(false); 
        /*Resuming the session created  
                                        in the previous servlet using  
                                        the same method that was used 
                                        to create the session.  
                                        The boolean parameter 'false' 
                                        has been passed so that a new session 
                                        is not created since the session already 
                                        exists*/
        
        String n = (String)session.getAttribute("currentSessionUser"); 
        out.println("<div>");
        out.print("Hello " + n); 
        out.print("</div>");
            try{
    Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DEMO", "aaru321");
    Statement stm =con.createStatement();
    /*String query = "CREATE TABLE AMITY_TABLES.EME( "
         + "Id VARCHAR(255), "
         + "Name VARCHAR(255), "
         + "Salary INT NOT NULL, "
         + "Location VARCHAR(255), "
         + "PRIMARY KEY (Id))";
                stm.execute(query);
                out.print("Table created");*/
    String s1="select * FROM AMITY_TABLES.EME";
    ResultSet res= stm.executeQuery(s1);
    //response.sendRedirect("select_flight1.jsp");
    //String formt = "%s\t| %s\t| %s\t| %s";
    //out.println(String.format(format, "ID", "AGE", "FIRST", "LAST"));
    //out.println("<form action=");
    out.println("<TABLE border=\"4\">");
    out.println("<TR><TD>ID</TD><TD>AIRLINE NAME</TD><TD>PRICE</TD><TD>BOOK</TD></TR>");
    while(res.next())
    {
        //out.println(res.getString(1)+res.getString(2)+res.getString(3));
        //out.println("<br>");
        
         String id  = res.getString(1);
         //int age = res.getInt("age");
         String first = res.getString(2);
         String last = res.getString(3);
         out.println("<TR>");
         //Display values
         out.println("<TD>");
         out.print("" + id);
         out.println("</TD>");
         //System.out.print(", Age: " + age);
         out.println("<TD>");
         out.print(" " + first);
         out.println("</TD>");
         out.println("<TD>");
         out.println(" " + last);
         out.println("</TD>");
         out.println("<TD>");
         out.println("<a href=\"select_flight.jsp?id="+res.getString(1)+"&first="+res.getString(2)+"&last="+res.getString(3)+"\""+">Book</a></TD>");
         out.println("</TR>");
         out.println("<br>");
         
         
    }
    out.println("</TABLE>");
        //HttpSession session = request.getSession(false);
        session.setAttribute("id",res.getString(1)); 
        session.setAttribute("first", res.getString(2));
        session.setAttribute("last", res.getString(3));
    }
    catch(Exception e){
    System.out.println(e);
           }
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
