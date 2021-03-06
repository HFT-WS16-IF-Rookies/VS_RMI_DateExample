package de.hft_stuttgart.vs_rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class DateServer extends UnicastRemoteObject implements IDateProvider
{
    private static final long serialVersionUID = 1l;

    protected DateServer() throws RemoteException
    {
        super();
    }

    @Override
    public Date getDate() throws RemoteException
    {
        return new Date();
    }

    private static Registry reg;

    public static void main(String[] args)
    {
        try
        {
            reg = LocateRegistry.createRegistry(1099);
            reg.rebind(IDateProvider.class.getName(), new DateServer());
            System.out.println("DateServer successfully bound to Registry");
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
