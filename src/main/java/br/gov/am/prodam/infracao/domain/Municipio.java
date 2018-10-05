package br.gov.am.prodam.infracao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MUNICIPIO")
@SequenceGenerator(name = "MUNICIPIO_GENERATOR", sequenceName = "MUNICIPIO_SEQ", allocationSize = 1)
public class Municipio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MUNICIPIO_GENERATOR")
	private Long id;
	
	@Column(name="NOME", length=50, nullable=false)
	@NotNull
	private String nome;
	
	@Column(name="DESCRICAO", length=250, nullable=true)
	private String descricao;
	
	@Column(name = "FOTO", columnDefinition = "BLOB", nullable=true)
	@Lob
	private String foto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Municipio other = (Municipio) obj;
		if (id != other.id)
			return false;
		return true;
	}	

}
