package com.orderworks.oswork.domain.services.ordemservicos;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.presents.OrdemServicosPresent;
import com.orderworks.oswork.domain.repository.OrdemServicosRepository;
import com.orderworks.oswork.domain.request.OrdemServicosRequest;
@Service
public class ConvertOrdemService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private OrdemServicosRepository ordemServicosRepository;
	
	public OrdemServicosPresent toModel(OrdemServicos ordemServico) {
		OrdemServicosPresent present = modelMapper.map(ordemServico, OrdemServicosPresent.class);
		return present;
	}
	
	public List<OrdemServicosPresent> toCollection(List<OrdemServicos> ordemServicos) {
		return ordemServicos.stream()
				.map(ordemServico -> toModel(ordemServico))
				.collect(Collectors.toList());
	}

	public OrdemServicos toEntity(OrdemServicosRequest ordemServicosRequest) {
		return modelMapper.map(ordemServicosRequest, OrdemServicos.class);
	}
}
