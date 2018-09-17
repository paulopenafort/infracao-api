package br.gov.am.prodam.infracao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INFRACAO")
@SequenceGenerator(name = "INFRACAO_GENERATOR", sequenceName = "INFRACAO_SEQ", allocationSize = 1)
public class Infracao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFRACAO_GENERATOR")
	private Long id;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "NATUREZA", nullable = false)
	private NaturezaInfracao natureza;

	@Enumerated(EnumType.STRING)
	@Column(name = "COMPETENCIA", nullable = false)
	private Competencia competencia;

	@Column(name = "MULTIPLICADOR")
	private Integer multiplicador;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_INFRATOR", nullable = false)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Infracao other = (Infracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
