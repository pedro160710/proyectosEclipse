package org.jboss.samples.webservices;

import java.rmi.RemoteException;

public class Prueba {

	public static void main(String[] args) throws RemoteException {
		HelloWorld h = new HelloWorldProxy();
		System.out.println("Res " + h.hola());
	}

}
