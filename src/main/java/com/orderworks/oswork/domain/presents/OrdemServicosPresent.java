package com.orderworks.oswork.domain.presents;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.orderworks.oswork.domain.model.Cliente;
import com.orderworks.oswork.domain.model.StatusOrdemServicos;

public class OrdemServicosPresent {
	private Long id;
	private ClienteResumePresent cliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServicos status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;
	
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
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public StatusOrdemServicos getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServicos status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public ClienteResumePresent getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResumePresent cliente) {
		this.cliente = cliente;
	}
}
