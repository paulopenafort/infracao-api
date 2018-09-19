package br.gov.am.prodam.infracao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "AGENTE_TRANSITO")
@SequenceGenerator(name = "AGENTE_TRANSITO_GENERATOR", sequenceName = "AGENTE_TRANSITO_SEQ", allocationSize = 1)
public class AgenteTransito {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENTE_TRANSITO_GENERATOR")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "CPF", nullable = false, length = 11)
	@CPF
	private String cpf;

	@Column(name = "EMAIL", nullable = false)
	@Email
	private String email;

	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "ID_ORGAO_AUTUADOR", nullable = false)
	private OrgaoAutuador orgaoAutuador;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public OrgaoAutuador getOrgaoAutuador() {
		return orgaoAutuador;
	}

	public void setOrgaoAutuador(OrgaoAutuador orgaoAutuador) {
		this.orgaoAutuador = orgaoAutuador;
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
		AgenteTransito other = (AgenteTransito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
