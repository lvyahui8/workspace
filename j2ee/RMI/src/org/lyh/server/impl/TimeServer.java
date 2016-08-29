package org.lyh.server.impl;

import org.lyh.server.ITimeServer;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by lvyahui on 2016/4/22.
 */
public class TimeServer extends UnicastRemoteObject implements ITimeServer {

    public TimeServer(int port) throws RemoteException {
        super(port);
    }

    public TimeServer() throws RemoteException {
    }

    public TimeServer(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public long getServerTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}

