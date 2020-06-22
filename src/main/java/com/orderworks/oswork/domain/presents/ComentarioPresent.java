package com.orderworks.oswork.domain.presents;

import java.time.OffsetDateTime;

import com.orderworks.oswork.domain.model.OrdemServicos;

public class ComentarioPresent {
	private Long id;
	private String descricao;
	private OffsetDateTime dataCriacao;
	private OrdemServicos ordemServico;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(OffsetDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public OrdemServicos getOrdemServico() {
		return ordemServico;
	}
	public void setOrdemServico(OrdemServicos ordemServico) {
		this.ordemServico = ordemServico;
	}
	
}
