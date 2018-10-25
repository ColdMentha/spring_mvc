package com.web.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnect {
    static private Logger log = Logger.getLogger(DataBaseConnect.class.getName());
    final private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String url;
    final private static String server = "localhost";
    final private static String port = "1521";
    final private static String sid = "XE";
    final private static String username = "root";
    final private static String password = "q1234";

    private static Connection connection;
    private static boolean isConnected = false;

    private static boolean connect() {
        try {
            url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
            System.out.println(url);
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connecting: " + url);
            if (connection.equals(null))
                isConnected = false;
            else
                isConnected = true;
        } catch (ClassNotFoundException e) {
            log.log(Level.WARNING, "ClassNotFoundException", e);
            isConnected = false;
        } catch (SQLException e) {
            log.log(Level.WARNING, "SQLException", e);
            isConnected = false;
        }
        return isConnected;
    }

    public static void main(String[] args) {
        if (connect()) System.out.println("connected");
        else System.out.println("not connected");
    }
}
