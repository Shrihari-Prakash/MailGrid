package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;

public class DataOk extends HttpServlet {

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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("fname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("password1");
        String hashed = getSha256(password);

        User user = new User();
        user.setName(username);
        user.setPassword(hashed);
        user.setEmail(email);
        RegistrationBO registrationBO = new RegistrationBO();
        int i = registrationBO.saveUser(user);

        if (i != 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("registeredUser.jsp");
            dispatcher.forward(request, response);

        } else {
            out.println("failed to insert the data");
        }

    }
}
