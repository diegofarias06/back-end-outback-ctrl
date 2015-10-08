package com.controller.entidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		cliente = clientes.get(clientes.size() - 1);
		return String.valueOf(cliente.getId());
	}

	public ArrayList<Cliente> listarTodos(){
		Cliente temp = new Cliente();
		for(int i = 0; i < clientes.size(); i++){
			temp.setNome(clientes.get(i).getNome());
			temp.setTelefone(clientes.get(i).getTelefone());
			temp.setId(clientes.get(i).getId());
			temp.setnMesa(clientes.get(i).getnMesa());
			clientesJson.add(temp);
		}
		return clientesJson;
	}
	
	public Map<String, List<Cliente>> listar(){
		Map<String, List<Cliente>> filas = new HashMap<String, List<Cliente>>();
		
		for(int i = 2; i <= 10; i = i+2){
			List <Cliente> filaInicio = new ArrayList<Cliente>(); 
			filas.put(String.valueOf(i), filaInicio);
		}
		
		for(int i = 15; i <= 30; i = i*2){
			List <Cliente> filaInicio = new ArrayList<Cliente>(); 
			filas.put(String.valueOf(i), filaInicio);
		}
		
		for(Cliente cliente : clientes){
			String chave = String.valueOf(cliente.getnMesa());
			List <Cliente> fila = filas.get(chave);
			if(fila == null){
				fila = new ArrayList<Cliente>();
				fila.add(cliente);
				filas.put(chave, fila);
			}
			else{
				fila.add(cliente);
				filas.put(chave, fila);
			}
		}

		return filas;
	}
	
	public String remover(Cliente cliente){
		repositorioCliente.removerCliente(cliente);
		clientes = repositorioCliente.listarTodos();
		return "true";
	}

	public String removerId(int id){
		repositorioCliente.removerId(id);
		return "true";
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
