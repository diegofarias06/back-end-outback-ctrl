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
	
	ControleCliente controleCliente = new ControleCliente();
	Gson gson = new Gson();
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public String listarTodos(){
		Gson gson = new Gson();
		return gson.toJson(controleCliente.listar());
	}
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public String listar(){
		return gson.toJson(controleCliente.getClientes());
	}
	
	@POST
	@Path("/enviarCliente")
	@Produces("application/text")
	public String enviarCliente(Cliente cliente){
		return controleCliente.add(cliente);
	}		
}

