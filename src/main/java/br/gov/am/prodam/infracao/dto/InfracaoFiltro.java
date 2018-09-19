package br.gov.am.prodam.infracao.dto;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import br.gov.am.prodam.infracao.domain.Competencia;
import br.gov.am.prodam.infracao.domain.NaturezaInfracao;
import br.gov.am.prodam.infracao.domain.TipoInfrator;

public class InfracaoFiltro {

	@QueryParam("natureza")
	private NaturezaInfracao natureza;

	@QueryParam("competencia")
	@DefaultValue("E")
	private Competencia competencia;

	@QueryParam("descricao")
	private String descricao;

	@QueryParam("tipoInfrator")
	private TipoInfrator tipoInfrator;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoInfrator getTipoInfrator() {
		return tipoInfrator;
	}

	public void setTipoInfrator(TipoInfrator tipoInfrator) {
		this.tipoInfrator = tipoInfrator;
	}

}
