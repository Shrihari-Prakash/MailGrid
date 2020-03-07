package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InboxServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();

            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String hashed = getSha256(password);

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mgdb;create=true;user=root;password=root");
            String query = "SELECT * FROM userinfo ";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM userinfo ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cemail = rs.getString("email");
                String cpass = rs.getString("pass");
                if (email.equals(cemail) && hashed.equals(cpass)) {
                    getServletContext().setInitParameter("logemail", email);
                    session.setAttribute("logemail", email);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("InboxView");
                    dispatcher.forward(request, response);
                }

            }
        } catch (Exception e) {
            out.println(e);
        }
        out.println("Username Or Password Is Incorrect!<a href=\"Login.jsp\"><br>Go To Home.</a>");

    }

    public static String getSha256(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return bytesToHex(md.digest());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
