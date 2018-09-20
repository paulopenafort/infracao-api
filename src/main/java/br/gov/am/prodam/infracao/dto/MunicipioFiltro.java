package br.gov.am.prodam.infracao.dto;

import javax.ws.rs.QueryParam;


public class MunicipioFiltro {
	
	@QueryParam("nome")
	private String nome;
	
	@QueryParam("descricao")
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
