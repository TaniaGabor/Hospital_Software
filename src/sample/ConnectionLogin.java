package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionLogin{
    public static Connection connection;
    public static  Connection getConnection(){


        String dbName="policlinica";
        String userName="root";
        String password="parola123@";

        try {


            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}