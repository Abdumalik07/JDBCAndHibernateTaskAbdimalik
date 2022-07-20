package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5432/sql_practice";
    private static final String userName = "postgres";
    private static final String password = "postgres";

    public static Connection connection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,userName,password);
            System.out.println("Connected to the PostgresSQL successfully");
        }catch (SQLException e){
            e.getMessage();
        }
        return conn;
    }

}
