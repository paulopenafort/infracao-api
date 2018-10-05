package br.gov.am.prodam.infracao.dto;

import javax.ws.rs.QueryParam;

public class VeiculoFiltro2 {
	@QueryParam("nome")
	private String nome;
	
	@QueryParam("cor")
	private String cor;
	
	@QueryParam("marca")
	private String marca;
	
	@QueryParam("anomodelo")
	private int anoModelo;
		
	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
