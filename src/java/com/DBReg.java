package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBReg extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("fname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("password1");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mgdb;create=true;user=root;password=root");
            String query = "SELECT * FROM userinfo ";
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM userinfo ");
            ResultSet rs = ps1.executeQuery();
            int dn = 0;
            mainloop:

            while (rs.next()) {
                String cemail = rs.getString("email");

                if (email.equals(cemail)) {

                    dn++;
                }
            }
            if (dn == 0) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("DataOk");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("UserTaken.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println("Error Accessing Database! Please Try Again!");
        }

    }
}
