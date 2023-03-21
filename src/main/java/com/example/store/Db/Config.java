package com.example.store.Db;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Getter
@Setter
public class Config{
    private static final String jdcurl= "jdbc:mysql://localhost:3306/Store";

private static final String username= "root";
private static final String password= "jwsven7766";
private static final String query = "SELECT * FROM signup";
public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection=null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
        jdcurl,
        username,
        password
        );
        return connection;
        }

}