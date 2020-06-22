package com.orderworks.oswork.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orderworks.oswork.domain.execption.NotFoundEntityException;
import com.orderworks.oswork.domain.model.Comentario;
import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.presents.ComentarioPresent;
import com.orderworks.oswork.domain.repository.OrdemServicosRepository;
import com.orderworks.oswork.domain.request.ComentarioRequest;
import com.orderworks.oswork.domain.services.comentarios.ConvertComentario;
import com.orderworks.oswork.domain.services.ordemservicos.GestaoOrdemServicosService;

@RestController
@RequestMapping("ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {
	@Autowired
	private GestaoOrdemServicosService gestaoOrdemServicosService;
	@Autowired
	private ConvertComentario convertComentario;
	
	@Autowired
	private OrdemServicosRepository ordemServicosRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioPresent add(@PathVariable Long ordemServicoId, @Valid @RequestBody ComentarioRequest comentarioRequest) {
		Comentario comentario = gestaoOrdemServicosService.addComent(ordemServicoId, comentarioRequest.getDescricao());
		return convertComentario.toModel(comentario);
	}
	
	@GetMapping
	public List<ComentarioPresent> list(@PathVariable Long ordemServicoId) {
		OrdemServicos ordemServicos = ordemServicosRepository.findById(ordemServicoId)
				.orElseThrow(() -> new NotFoundEntityException("Ordem de Serviço não encontrada"));
		return convertComentario.toCollection(ordemServicos.getComentarios());
	}
}
