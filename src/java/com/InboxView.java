package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InboxView extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            String logemail = (String) session.getAttribute("logemail");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mgdb;create=true;user=root;password=root");
            String query = "SELECT * FROM inbox ";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM inbox WHERE toemail ='" + logemail + "'");
            ResultSet rs = ps.executeQuery();
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <title>Mail Grid | Inbox</title>\n"
                    + "         <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css\">\n"
                    + "         \n"
                    + "    </head>\n"
                    + "     <body background=\"bg.jpg\" style=\"background-size: 100%; background-attachment: fixed;\">\n"
                    + "             <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                    + "      <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>   <nav>\n"
                    + "    <div class=\"nav-wrapper\">\n"
                    + "      <div class=\"col s12\">\n<div class=\"panel light-blue accent-4\">"
                    + "        <a href=\"#!\" class=\"breadcrumb\">Home</a>\n"
                    + "        <a href=\"#!\" class=\"breadcrumb\">Inbox</a>\n"
                    + "      </div>\n"
                    + "    </div></div>\n"
                    + "  </nav> <div class=\"row\">\n"
                    + "            <div class=\"col s12 m10\">\n"
                    + "             <div class=\"card blue-white lighten-1\" > \n"
                    + "                    <div class=\"card-content black-text\">\n"
                    + "    \n"
                    + "                        <img src='email-icon.png'width=\"48\" height=\"48\"style=\"float:left;margin-top: 1px; margin-left: -5px\"> <h5 style=\"margin-left: 56px\">Mail Grid</h5><font style=\"margin-left: 56px\">- An Inter Organization Email Framework.</font>\n"
                    + "                    </div>      </div>      </div>      </div>\n"
                    + "<div class=\"row\">\n"
                    + "            <div class=\"col s12 m10\">\n"
                    + "             <div class=\"card blue-white lighten-1\"> \n"
                    + "                    <div class=\"card-content black-text\">\n<h5>Welcome To Your Inbox:</h5><a href=\"compose.jsp\">Compose a Mail</a><a href=\"LogoutServlet\"> | Logout</a> ");
            if (rs == null) {
                out.println("No Emails To Show...");
            }
            while (rs.next()) {
                String femail = rs.getString("fromemail");
                String content = rs.getString("content");
                String date = rs.getString("date");
                String deccon = AESCrypt.decrypt(content);

                out.println(""
                        + " <div class=\"row\">\n"
                        + "            <div class=\"col s12 m9\">\n"
                        + "                <div class=\"card white darken-1\"> \n"
                        + "                    <div class=\"card-content black-text\">\n"
                        + "                        <p><b>From:<br></b> " + femail + "</p>\n<br>"
                        + "                        <p><b>Message:<br></b>" + deccon + "</p>\n<br>"
                        + "         <font color=\"grey\"> <p><i>Sent on: " + date + "</i></p></font>\n"
                        + "                    </div>\n"
                        + "                    <div class=\"card-action\">\n"
                        + "                        <a href=\"compose.jsp\">Reply</a>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "");
            }
            out.println("<div class=\"row\">\n"
                    + "<div class=\"col s12 m9\">\n<div class=card><i>"
                    + "Looks like you've reached the end... No more E-Mails to show! </i> "
                    + "</div></div></div><a href=\"compose.jsp\">Compose a Mail</a>"
                    + "<a href=\"LogoutServlet\"> | Logout</a>");
            out.println("</div></div></div></div></div></body></html>");
        } catch (Exception e) {
            out.println(e);
        }
    }
}
