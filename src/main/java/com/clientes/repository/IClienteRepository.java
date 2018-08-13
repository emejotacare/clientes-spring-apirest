package com.clientes.repository;

import org.springframework.data.repository.CrudRepository;

import com.clientes.entity.Cliente;

/* Cliente --> Entity asociada a este DAO
 * Long --> Tipo de dato de la clave primaria de la entity
 */
public interface IClienteRepository extends CrudRepository<Cliente, Long> {
	
}
