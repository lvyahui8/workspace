package com.tencent.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {

//    private static final String pass = "root";
//    private static final String user = "root";
//    private static final String url = "jdbc:mysql://127.0.0.1/rc";

    public static String configFile = "conf/db.properties";

    private static String pass;
    private static String user;
    private static String url;

    private static Connection connection;

    private static final String driverClass = "com.mysql.jdbc.Driver";
    private static boolean isLoaded = false;
    public static Connection getConnection() {
        if(!isLoaded){
            loadProps();
        }
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("打开DB连接");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void loadProps() {
        Properties dbProps = new Properties();
        try {
            dbProps.load(new FileInputStream(new File(configFile)));
            url = "jdbc:mysql://"
                    + dbProps.getProperty("db.host","127.0.0.1")
                    + ":" + dbProps.getProperty("db.port","3306")
                    + "/" + dbProps.getProperty("db.name");
            user = dbProps.getProperty("db.user");
            pass = dbProps.getProperty("db.pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void closeConnection() {
        System.out.println("关闭DB连接");
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
