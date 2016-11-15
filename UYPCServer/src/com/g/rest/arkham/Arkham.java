package com.g.rest.arkham;



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
		if(id == 0 || id > 4) return "-1"; // Error valores fuera de rango
		jokerState = id;
		return ""+jokerState;
	}
	
	
	

}
