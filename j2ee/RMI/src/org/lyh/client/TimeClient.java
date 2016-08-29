package org.lyh.client;

import org.lyh.server.ITimeServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by lvyahui on 2016/4/22.
 */
public class TimeClient {
    public static void main(String[] args) {
        try {
           ITimeServer iTimeServer = (ITimeServer) Naming.lookup("rmi://192.168.18.1/t1");
            System.out.println(iTimeServer.getServerTime());
            System.out.println(iTimeServer.add(3,7));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
