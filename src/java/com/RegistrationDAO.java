package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationDAO {

    public int saveUser(User user) {
        int i = 0;
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/mgdb;create=true;user=root;password=root");

            /*Table Creation*/
            /*Statement sta = con.createStatement(); 
            int count = sta.executeUpdate(
            "CREATE TABLE userinfo ( fName VARCHAR(20),"
            + " pass VARCHAR(20))"+ " email VARCHAR(30))");
            System.out.println("Table created.");
            sta.close();
    
            CREATE TABLE userinfo ( fName VARCHAR(20), pass VARCHAR(64), email VARCHAR(128));*/
            PreparedStatement pst = con.prepareStatement("insert into userinfo values(?,?,?)");

            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            i = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }
}
