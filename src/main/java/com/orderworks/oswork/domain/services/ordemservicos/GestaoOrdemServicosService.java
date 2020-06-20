package com.orderworks.oswork.domain.services.ordemservicos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderworks.oswork.domain.model.Cliente;
import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.model.StatusOrdemServicos;
import com.orderworks.oswork.domain.repository.ClienteRepository;
import com.orderworks.oswork.domain.repository.OrdemServicosRepository;

@Service
public class GestaoOrdemServicosService {
	
	@Autowired
	private OrdemServicosRepository ordemServicosRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public OrdemServicos store(OrdemServicos ordemServicos) {
		Cliente cliente = clienteRepository.findById(ordemServicos.getCliente().getId())
				.orElseThrow();
		ordemServicos.setCliente(cliente);
		ordemServicos.setStatusOrdemServicos(StatusOrdemServicos.ABERTA);
		ordemServicos.setDataAbertura(LocalDateTime.now());
		return ordemServicosRepository.save(ordemServicos);
	}
}
