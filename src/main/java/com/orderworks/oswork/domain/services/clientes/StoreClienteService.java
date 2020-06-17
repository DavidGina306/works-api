package com.orderworks.oswork.domain.services.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderworks.oswork.domain.model.Cliente;
import com.orderworks.oswork.domain.repository.ClienteRepository;
@Service
public class StoreClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente store(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
