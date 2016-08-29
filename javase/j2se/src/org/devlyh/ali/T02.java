package org.devlyh.ali;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 2015/8/23.
 */
/*

 */
public class T02 implements Runnable{
    private static Connection connection = null;
    private static boolean isFinish = false;
    private User user ;
    private Socket socket ;
    public T02(Socket socket) {

        try {
            InputStream inputStream = socket.getInputStream();
            byte [] buf = new byte[255];
            int length=inputStream.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.user = user;
    }

    public static void init(){
        try {
            connection = DriverManager.getConnection("url","user","pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void invest(User user ,int money){

    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(!isFinish){
                Socket socket = serverSocket.accept();
                new Thread(new T02(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

    }
}
