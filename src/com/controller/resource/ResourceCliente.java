package com.controller.resource;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.controller.entidade.ControleCliente;
import com.model.entidade.Cliente;

@Path("/cliente")
public class ResourceCliente {
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public String listarTodos(){
		Gson gson = new Gson();
		return gson.toJson(new ControleCliente().getClientes());
	}
	
	@POST
	@Path("/enviarCliente")
	@Produces("application/text")
	public String enviarCliente(Cliente cliente){
		System.out.println("chegou");
		return new ControleCliente().add(cliente);
	}		
}

