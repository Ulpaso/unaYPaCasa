package com.g.rest.gestorArkham;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

public class gestorArkham  {

	private static ClientConfig config = new ClientConfig();
    private static Client client;
    private static WebTarget target;
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		config.property(ClientProperties.CONNECT_TIMEOUT, 100000);
		config.property(ClientProperties.READ_TIMEOUT, 100000);
		
		client = ClientBuilder.newClient(config);
		
		if (args.length < 1)
		{
			System.out.println("Falta especificar la IP como argumento.");
			System.exit(-1);
		}
		
		
		target = client.target(getBaseURI(args[0]));
		
		menu();
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("");
	}
	private int comprobarEstado(){
		return 0;
		
	}
	
	private static URI getBaseURI(String ip) { // Pasar por argumento
	    return UriBuilder.fromUri("http://"+ ip + "/UYPCServer").build();
	}
}
