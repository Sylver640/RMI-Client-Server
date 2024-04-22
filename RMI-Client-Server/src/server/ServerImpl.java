package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.Persona;

public class ServerImpl implements InterfazDeServer{
	
	private ArrayList<Persona> database;
	
	public ServerImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
		this.database = new ArrayList<Persona>();
	}
	
	public void dataInicial() {
		database.add(new Persona("Pepe", 18));
		database.add(new Persona("Maria", 23));
		database.add(new Persona("Javiera", 20));
	}

	@Override
	public ArrayList<Persona> getPersonas() throws RemoteException {
		
		
		
		return database;
	}

	@Override
	public void Persona(String nombre, int edad) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
