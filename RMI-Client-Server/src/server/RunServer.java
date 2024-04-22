package server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.InterfazDeServer;

public class RunServer {
	public static void main(String args[]) throws RemoteException {
		InterfazDeServer server = new ServerImpl();
		//Lista de objetos que el cliente puede acceder
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("severDePersonas", server);
		
		System.out.println("Servidor Arriba");
	}
}
