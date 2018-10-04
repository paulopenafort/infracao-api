package br.gov.am.prodam.infracao.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AGENTE_TRANSITO_FOTO")
@SequenceGenerator(name = "AGENTE_TRANSITO_FOTO_GENERATOR", sequenceName = "AGENTE_TRANSITO_FOTO_SEQ", allocationSize = 1)
public class AgenteTransitoFoto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENTE_TRANSITO_FOTO_GENERATOR")
	private Long id;

	@OneToOne
	@JoinColumn(name = "ID_AGENTE_TRANSITO", nullable = false)
	private AgenteTransito agente;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "tipo")
	private String tipo;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "FOTO", nullable = false)
	private byte[] foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AgenteTransito getAgente() {
		return agente;
	}

	public void setAgente(AgenteTransito agente) {
		this.agente = agente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		AgenteTransitoFoto other = (AgenteTransitoFoto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
