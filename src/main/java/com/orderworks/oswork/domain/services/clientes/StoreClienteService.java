package com.orderworks.oswork.domain.services.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderworks.oswork.domain.execption.WorkExecption;
import com.orderworks.oswork.domain.model.Cliente;
import com.orderworks.oswork.domain.repository.ClienteRepository;
@Service
public class StoreClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente store(Cliente cliente) {
		Cliente clienteExist = clienteRepository.findByEmail(cliente.getEmail());
		if(clienteExist != null && !clienteExist.equals(cliente) ) {
			throw new WorkExecption("Cliente já existente");
		}
		
		return clienteRepository.save(cliente);
	}
}
