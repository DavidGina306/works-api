package com.orderworks.oswork.domain.services.clientes;

import org.springframework.beans.factory.annotation.Autowired;

import com.orderworks.oswork.domain.model.Cliente;
import com.orderworks.oswork.domain.repository.ClienteRepository;

public class UpdateClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente update(Long clienteId, Cliente cliente) {
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		return clienteRepository.save(cliente);
	}
}
