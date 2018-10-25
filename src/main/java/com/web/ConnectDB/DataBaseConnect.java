package com.web.ConnectDB;

import java.sql.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnect {

    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "root";
        String password = "q1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            String sql;
            sql = "SELECT * FROM Person";
            ResultSet set = statement.executeQuery(sql);

            while (set.next()) {
                int id = set.getInt("id_person");
                String last_name = set.getString("last_name");
                String first_name = set.getString("first_name");

                System.out.println(id + " " + last_name + " " + first_name);

            }

            set.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
