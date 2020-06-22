package com.orderworks.oswork.domain.services.ordemservicos;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderworks.oswork.domain.execption.NotFoundEntityException;
import com.orderworks.oswork.domain.execption.WorkExecption;
import com.orderworks.oswork.domain.model.Cliente;
import com.orderworks.oswork.domain.model.Comentario;
import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.model.StatusOrdemServicos;import com.orderworks.oswork.domain.presents.ComentarioPresent;
import com.orderworks.oswork.domain.repository.ClienteRepository;
import com.orderworks.oswork.domain.repository.ComentarioRepository;
import com.orderworks.oswork.domain.repository.OrdemServicosRepository;

@Service
public class GestaoOrdemServicosService {
	
	@Autowired
	private OrdemServicosRepository ordemServicosRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public OrdemServicos store(OrdemServicos ordemServicos) {
		Cliente cliente = clienteRepository.findById(ordemServicos.getCliente().getId())
				.orElseThrow(() -> new NotFoundEntityException("Cliente não encontrado"));
		ordemServicos.setCliente(cliente);
		ordemServicos.setStatusOrdemServicos(StatusOrdemServicos.ABERTA);
		ordemServicos.setDataAbertura(OffsetDateTime.now());
		return ordemServicosRepository.save(ordemServicos);
	}
	
	public Comentario addComent(Long ordemServicoId, String descricao) {
		OrdemServicos ordemServico = buscar(ordemServicoId);
		var comentario = new Comentario();
		comentario.setDataCriacao(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServicos(ordemServico);
		return comentarioRepository.save(comentario);
	}

	private OrdemServicos buscar(Long ordemServicoId) {
		return ordemServicosRepository.findById(ordemServicoId)
				.orElseThrow(() -> new NotFoundEntityException("Ordem de serviço não encontrada"));
	}
	
	public void finish(Long ordemServicoId) {
		OrdemServicos ordemServico = buscar(ordemServicoId);
		if(!validarOrdemFinalizacao(ordemServico)) {
			throw new WorkExecption("Ordem de serviço não pode ser finalizada");
		}
		ordemServico.setStatusOrdemServicos(StatusOrdemServicos.FINALIZADA);
		ordemServico.setDataFinalizacao(OffsetDateTime.now());
		ordemServicosRepository.save(ordemServico);
	}
	
	public boolean validarOrdemFinalizacao(OrdemServicos ordemServico) {
		if(StatusOrdemServicos.ABERTA.equals(ordemServico.getStatusOrdemServicos())) {
			return true;
		}
		return false;
	}
}
