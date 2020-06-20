package com.orderworks.oswork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.services.ordemservicos.GestaoOrdemServicosService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicosController {
	
	@Autowired
	private GestaoOrdemServicosService gestaoOrdemServicosService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public OrdemServicos store(@Valid @RequestBody OrdemServicos ordemServico) {
		return gestaoOrdemServicosService.store(ordemServico);
	}
}
