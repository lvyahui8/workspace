package org.lyh.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lvyahui on 2016/4/22.
 */
public interface ITimeServer extends Remote {
    long getServerTime() throws RemoteException;
    int add(int a,int b) throws RemoteException;
}
