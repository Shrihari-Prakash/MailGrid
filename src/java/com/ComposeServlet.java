package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComposeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            int i = 0;

            String password = request.getParameter("password");
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("logemail");
            String toemail = request.getParameter("toemail");
            String timeStamp = new SimpleDateFormat("dd/MM/yy - hh:mm a").format(new Date());
            String content = request.getParameter("content");
            String encryptedContent = AESCrypt.encrypt(content);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mgdb;create=true;user=root;password=root");

            /*Table Creation*/
            /*Statement sta = con.createStatement(); 
            int count = sta.executeUpdate(
            "CREATE TABLE inbox ( fromemail VARCHAR(150),"
            + " toemail VARCHAR(150))"+ " content VARCHAR(350))");
            System.out.println("Table created.");
            sta.close();
    
            CREATE TABLE inbox ( fromemail VARCHAR(150), toemail VARCHAR(150), content VARCHAR(350));*/
            
            PreparedStatement pst = con.prepareStatement("insert into inbox values(?,?,?,?)");

            pst.setString(1, email);
            pst.setString(2, toemail);
            pst.setString(3, encryptedContent);
            pst.setString(4, timeStamp);

            i = pst.executeUpdate();
            out.println(" <html> <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <title></title>\n"
                    + "         <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css\">\n"
                    + "         \n"
                    + "    </head><body\n"
                    + "        <link rel=\\\"stylesheet\\\" href=\\\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css\\\">  \n"
                    + "    <center><div class=\"row\">\n"
                    + "            <div class=\"col s12 m6\">\n"
                    + "                <div class=\"card blue-grey darken-1\"> \n"
                    + "                    <div class=\"card-content white-text\">\n"
                    + "                        <span class=\"card-title\">Mail Sent!</span>\n"
                    + "                        <p>Your mail has been sent successfully!</p>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"card-action\">\n"
                    + "                        <a href=\"InboxView\">Inbox</a>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </center>\n"
                    + "</body></html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
