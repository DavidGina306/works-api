package com.orderworks.oswork.domain.services.comentarios;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderworks.oswork.domain.model.Comentario;
import com.orderworks.oswork.domain.model.OrdemServicos;
import com.orderworks.oswork.domain.presents.ComentarioPresent;
import com.orderworks.oswork.domain.presents.OrdemServicosPresent;
import com.orderworks.oswork.domain.repository.ComentarioRepository;
import com.orderworks.oswork.domain.request.ComentarioRequest;
import com.orderworks.oswork.domain.request.OrdemServicosRequest;

@Service
public class ConvertComentario {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public ComentarioPresent toModel(Comentario comentario) {
		return modelMapper.map(comentario, ComentarioPresent.class);
	}
	
	public List<ComentarioPresent> toCollection(List<Comentario> comentarios) {
		return comentarios.stream()
				.map(comentario -> toModel(comentario))
				.collect(Collectors.toList());
	}

	public Comentario toEntity(ComentarioRequest comentarioRequest) {
		return modelMapper.map(comentarioRequest, Comentario.class);
	}
}
