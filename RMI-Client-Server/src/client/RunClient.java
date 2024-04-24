package client;

import java.io.IOException;
import java.rmi.NotBoundException;

public class RunClient {
	public static void main(String args[]) throws NotBoundException, IOException {
		Client client = new Client();
		client.startClient();
	}
}
