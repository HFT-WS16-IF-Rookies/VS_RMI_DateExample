package de.hft_stuttgart.vs_rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DateClient
{
    public static void main(String[] args)
    {
        try
        {
            Registry vRegistry = LocateRegistry.getRegistry();
            IDateProvider vDateProvider = (IDateProvider) vRegistry.lookup(IDateProvider.class.getName());
            System.out.println(vDateProvider.getDate());
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        catch (NotBoundException e)
        {
            e.printStackTrace();
        }
    }
}
