package de.hft_stuttgart.vs_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IDateProvider extends Remote
{
    public Date getDate() throws RemoteException;
}
