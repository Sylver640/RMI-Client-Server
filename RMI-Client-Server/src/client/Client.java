package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.io.*;

import common.InterfazDeServer;
import common.Persona;

public class Client {
	private InterfazDeServer server;
	
	public Client() {
		
	}
	
	public void startClient() throws NotBoundException, IOException{
		Registry registry = LocateRegistry.getRegistry("localhost", 1099);
		server = (InterfazDeServer) registry.lookup("severDePersonas");
		System.out.println("Conexión de cliente a servidor exitosa!");
		
		showMenu();
	}
	
	public ArrayList<Persona> getPersonas() throws RemoteException{
		return server.getPersonas();
	}
	
	public void showMenu() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----- MENÚ -----");
		System.out.println("1. Mostrar personas");
		System.out.println("2. Salir");
		
		int option = Integer.parseInt(br.readLine());
		System.out.println(option);
		
		switch(option) {
		case 1:
			showPersonas();
		case 2:
			return;
		}
	}
	
	public void showPersonas() throws RemoteException {
		ArrayList<Persona> database = getPersonas();
		System.out.println("NOMBRE   ,   EDAD");
		for(int i = 0; i < database.size(); i++) {
			Persona aux = (Persona)database.get(i);
			System.out.println(aux.getNombre() + "," + aux.getEdad());
		}
	}
	
	public void createPersona() throws IOException, RemoteException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Por favor ingrese el nombre de la persona: \n");
        String name = br.readLine();

        System.out.println("Por favor ingrese la edad de la persona: \n");
        int age = Integer.parseInt(br.readLine());

        server.addPersona(name, age);
    }
}
