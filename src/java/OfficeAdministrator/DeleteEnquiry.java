/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OfficeAdministrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rachna
 */
public class DeleteEnquiry extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        Statement st=DBConnector.getStatement();
        try{
        String query="delete from marketing where ID='"+id+"'";
        int i=st.executeUpdate(query);
        if(i>0)
            response.sendRedirect("Marketing.jsp");
        }catch(SQLException e){
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert(\"Something went wrong !! \n Please try again..\");");
            out.println("window.location.href=\"Marketing.jsp\";</script>");
            out.println("</body></html>");
        }
    }
  
}
