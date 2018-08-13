/**
 * 
 */
package com.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.entity.Cliente;
import com.clientes.service.ClienteService;

/**
 * @author María José
 *
 */

/*
 * @RestController --> En MVC sería @Controller
 * 
 * Con @RequestMapping generamos la url (endpoint) que mapeamos
 */
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	/* Inyectamos el servicio para poder listar los clientes del repositorio */
	@Autowired
	private ClienteService clienteService;
	
	/*
	 * Método para listar los clientes. Con GetMapping mapeamos la url (endpoint)
	 * del método
	 */
	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente listarClientePorId(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insertarCliente(@RequestBody Cliente cliente) {
		
		// Asignar fecha de creación del objeto cliente
		// cliente.setCreateAt(new Date());
		
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente modificarClientePorId(@PathVariable Long id, @RequestBody Cliente cliente) {
		
		/** Obtengo el cliente con ese id (Entidad) */
		Cliente clienteActual = clienteService.findById(id);
		
		/** Le asigno al objeto cliente (Entidad) los datos que le he pasado por json */
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		return clienteService.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
}
