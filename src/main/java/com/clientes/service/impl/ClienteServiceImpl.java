package com.clientes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.entity.Cliente;
import com.clientes.repository.IClienteRepository;
import com.clientes.service.ClienteService;

/**
 * Implementación del contrato (métodos) de la interfaz del servicio
 */
@Service
public class ClienteServiceImpl implements ClienteService {
	
	/**
	 * Inyectamos el repositorio
	 */
	@Autowired
	private IClienteRepository clienteRepository;
	
	/**
	 * Usamos el repositorio para acceder a la lista de clientes. (readOnly = true)
	 * --> porque la consulta es un select (solo lectura)
	 * 
	 * @Transactional se puede omitir en este método pk los métodos del repositorio
	 *                ya son transaccionales (Los métodos personalizados si deben
	 *                llevarla)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
		return clientes;
	}
	
	/**
	 * Buscar por id.
	 *
	 * @param id por el que buscamos el cliente
	 * @return cliente con ese id
	 * @return NoSuchElementException (orElseThrow()) - Si no encuentra el cliente
	 */
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow();
	}
	
	/**
	 * Método para guardar un cliente.
	 *
	 * @param cliente (Cliente que vamos a guardar)
	 * @return La Entidad Cliente que obtenemos
	 */
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	/**
	 * Borrar un cliente
	 * 
	 * @param id
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
}
