package com.controller.entidade;

import java.util.ArrayList;
import java.util.List;


import com.model.entidade.Cliente;
import com.model.repositorio.RepositorioCliente;

public class ControleCliente {
	List<Cliente> clientes;
	RepositorioCliente repositorioCliente;
	ArrayList<Cliente> clientesJson;

	public ControleCliente() {
		repositorioCliente = new RepositorioCliente();
		clientes = repositorioCliente.listarTodos();
	}

	public String add(Cliente cliente){
		repositorioCliente.salvarCliente(cliente);
		clientes = repositorioCliente.listarTodos();
		return "teste";
	}

	public ArrayList<Cliente> listarTodos(){
		Cliente temp = new Cliente();
		for(int i = 0; i < clientes.size(); i++){
			temp.setNome(clientes.get(i).getNome());
			temp.setTelefone(clientes.get(i).getTelefone());
			temp.setId(clientes.get(i).getId());
			clientesJson.add(temp);
		}
		return clientesJson;
	}

	public void remover(Cliente cliente){
		repositorioCliente.removerCliente(cliente);
		clientes = repositorioCliente.listarTodos();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
