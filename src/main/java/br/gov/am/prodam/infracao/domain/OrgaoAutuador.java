package br.gov.am.prodam.infracao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "ORGAO_AUTUADOR")
@SequenceGenerator(name = "ORGAO_AUTUADOR_GENERATOR", sequenceName = "ORGAO_AUTUADOR_SEQ", allocationSize = 1)
public class OrgaoAutuador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORGAO_AUTUADOR_GENERATOR")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "COMPETENCIA", nullable = false)
	private Competencia competencia;

	@Column(name = "RAZAO_SOCIAL", nullable = false)
	private String razaoSocial;

	@ManyToOne
	@JoinColumn(name = "ID_MUNICIPIO", nullable = false)
	private Municipio municipio;

	@Column(name = "CNPJ", nullable = false, length = 14)
	@CNPJ
	private String cnpj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
		OrgaoAutuador other = (OrgaoAutuador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
