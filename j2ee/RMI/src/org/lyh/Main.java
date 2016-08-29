package org.lyh;

import org.lyh.server.impl.TimeServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        try {
            TimeServer timeServer = new TimeServer();
            /* 绑定到JVM 的 RMI Server上*/
//            Naming.bind("t1",timeServer);
//            Naming.rebind("t1",timeServer);
            /* 当RMI注册server是指定了端口时或者不在本机运行时，需要这样写*/
            Naming.rebind("//localhost/t1",timeServer);
            System.out.println("Bind is Finish");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
