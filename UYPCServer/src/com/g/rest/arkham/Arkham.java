package com.g.rest.arkham;



import java.util.Scanner;

import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/arkham")
@Singleton
public class Arkham {
	
	public int jokerState; // id; 0 = no hacked, 1 = primer hackeo, 2 = hackeo
	public static boolean[] puertas = new boolean[7];
	// id 0 --> public static boolean dGuardias;
	// id 1 --> public static boolean dCeldas;
	// id 2 --> public static boolean dLaboratorio;
	// id 3 --> public static boolean dTaller;
	// id 4 --> public static boolean dJardin;
	// id 5 --> public static boolean dEnfermeria;
	// id 6 --> public static boolean dPuente;
	
	@Path("estado")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String arkhamState(){
		return ""+jokerState;
		
	}
	
	@Path("joker")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String joker(@DefaultValue("0") @QueryParam(value="id") int id){
		if(id == -1 || id > 4) return "-1"; // Error valores fuera de rango
		jokerState = id;
		return ""+jokerState;
	}
	
	@Path("door")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String setDoor(@DefaultValue("-1") @QueryParam(value="id0") int id0,
							@DefaultValue("-1") @QueryParam(value="id1") int id1, 
							@DefaultValue("-1") @QueryParam(value="id2") int id2, 
							@DefaultValue("-1") @QueryParam(value="id3") int id3, 
							@DefaultValue("-1") @QueryParam(value="id4") int id4, 
							@DefaultValue("-1") @QueryParam(value="id5") int id5, 
							@DefaultValue("-1") @QueryParam(value="id6") int id6 ){
		int[] id= new int[7];
		id[0]= id0; 
		id[1]= id1;
		id[2]= id2;
		id[3]= id3;
		id[4]= id4;
		id[5]= id5;
		id[6]= id6;
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < puertas.length; i++) {
			if(id[i] == -1 ){
				System.out.println(i+": (0=abierto; 1=cerrado)");
				String d = sc.nextLine();
				if(d == "0"){
					puertas[i]= true;
				}else{
					puertas[i] = false;
				}
			} else {
				if(id[i] == 0){
					puertas[i]= true;
				}else{
					puertas[i] = false;
				}
				
			}
		}
		String salida = "";
		for (int i = 0; i < puertas.length; i++) {
			salida = salida+puertas[i];
		}
		return salida;
	}
	
	@Path("guardias")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String guardias(){
		if(puertas[0])
		return "0";
		else
			return "1";
	}
	
	@Path("celdas")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String celdas(){
		if(puertas[1])
		return "0";
		else
			return "1";
	}
	
	@Path("laboratorio")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String laboratorio(){
		if(puertas[2])
		return "0";
		else
			return "1";
	}
	
	@Path("taller")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String talller(){
		if(puertas[3])
		return "0";
		else
			return "1";
	}
	
	@Path("jardin")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String jardin(){
		if(puertas[4])
		return "0";
		else
			return "1";
	}
	
	@Path("enfermeria")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String enfermeria(){
		if(puertas[5])
		return "0";
		else
			return "1";
	}
	
	@Path("puente")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String puente(){
		if(puertas[6])
		return "0";
		else
			return "1";
	}
}
