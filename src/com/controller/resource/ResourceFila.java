package com.controller.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.controller.entidade.ControleCliente;
import com.google.gson.Gson;
import com.model.entidade.Cliente;

@Path("/fila")
public class ResourceFila {
		
	@POST
	@Path("/removerCliente")
	@Produces("application/json")
	public void removerClienteFila(Cliente cliente){
		new ControleCliente().remover(cliente);
	}	

}
