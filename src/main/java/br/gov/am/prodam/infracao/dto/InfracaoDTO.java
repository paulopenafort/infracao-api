package br.gov.am.prodam.infracao.dto;

import br.gov.am.prodam.infracao.domain.Competencia;
import br.gov.am.prodam.infracao.domain.NaturezaInfracao;
import br.gov.am.prodam.infracao.domain.TipoInfrator;

public class InfracaoDTO {

	private Long id;

	private String descricao;

	private NaturezaInfracao natureza;

	private Competencia competencia;

	private Integer multiplicador;

	private TipoInfrator tipoInfrator;

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

	public NaturezaInfracao getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaInfracao natureza) {
		this.natureza = natureza;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public Integer getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(Integer multiplicador) {
		this.multiplicador = multiplicador;
	}

	public TipoInfrator getTipoInfrator() {
		return tipoInfrator;
	}

	public void setTipoInfrator(TipoInfrator tipoInfrator) {
		this.tipoInfrator = tipoInfrator;
	}

}
