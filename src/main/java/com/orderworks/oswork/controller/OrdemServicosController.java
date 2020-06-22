package com.orderworks.oswork.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.presents.OrdemServicosPresent;
import com.orderworks.oswork.domain.repository.OrdemServicosRepository;
import com.orderworks.oswork.domain.request.OrdemServicosRequest;
import com.orderworks.oswork.domain.services.ordemservicos.ConvertOrdemService;
import com.orderworks.oswork.domain.services.ordemservicos.GestaoOrdemServicosService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicosController {
	@Autowired
	private ModelMapper modelMap;
	@Autowired
	private GestaoOrdemServicosService gestaoOrdemServicosService;
	@Autowired
	private OrdemServicosRepository ordemServicosRepository;
	@Autowired
	private ConvertOrdemService convertOrdemServico;
	
	@PostMapping	
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrdemServicosPresent store(@Valid @RequestBody OrdemServicosRequest ordemServicoRequest) {
		OrdemServicos ordemServico = convertOrdemServico.toEntity(ordemServicoRequest);
		return convertOrdemServico.toModel(gestaoOrdemServicosService.store(ordemServico));
	}
	
	@GetMapping
	public List<OrdemServicosPresent> list() {
		return convertOrdemServico.toCollection(ordemServicosRepository.findAll());
	}
	
	@GetMapping("/{ordemId}")
	public ResponseEntity<OrdemServicosPresent> filter(@PathVariable Long ordemId) {
		Optional<OrdemServicos> ordemServico = ordemServicosRepository.findById(ordemId);
		if(ordemServico.isPresent()) {
			var present = convertOrdemServico.toModel(ordemServico.get());
			return ResponseEntity.ok(present);
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{ordemServicoId/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemServicoId) {
		gestaoOrdemServicosService.finish(ordemServicoId);
	}
}
