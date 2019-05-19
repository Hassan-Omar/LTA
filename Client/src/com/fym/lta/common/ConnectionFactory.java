package com.fym.lta.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ResourceBundle;

public class ConnectionFactory {
    private static String driver, url, username, password;


    public static void setDriverpath(String driverpath) {
        ConnectionFactory.driver = driverpath;
    }

    public static String getDriverpath() {
        return driver;
    }

    public static void setUrl(String url) {
        ConnectionFactory.url = url;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUsername(String username) {
        ConnectionFactory.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void setPassword(String password) {
        ConnectionFactory.password = password;
    }

    public static String getPassword() {
        return password;
    }
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("com.fym.lta.common.db");
        driver = bundle.getString("db.driver").toString();
        url = bundle.getString("url").toString();
        username = bundle.getString("username").toString();
        password = bundle.getString("password").toString();
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
