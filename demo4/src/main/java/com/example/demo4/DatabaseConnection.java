package com.example.demo4;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getconnection()
    {
        String databasename ="dbs_proj";
        String databaseuser ="root";
        String databasepassword="ThelionkinG.1";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databasename;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseuser,databasepassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }

}
