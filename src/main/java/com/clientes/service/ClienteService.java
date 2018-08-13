package com.clientes.service;

import java.util.List;

import com.clientes.entity.Cliente;

public interface ClienteService {
	
	/**
	 * Find all --> Listar todos los clientes
	 *
	 * @return Listado de Clientes
	 */
	public List<Cliente> findAll();
	
	/**
	 * Buscar por id.
	 *
	 * @param id por el que buscamos el cliente
	 * @return cliente con ese id
	 */
	public Cliente findById(Long id);
	
	/**
	 * Método para guardar un cliente.
	 *
	 * @param cliente (Cliente que vamos a guardar)
	 * @return Cliente que guardamos
	 */
	
	public Cliente save(Cliente cliente);
	
	/**
	 * Borrar un cliente
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
}
