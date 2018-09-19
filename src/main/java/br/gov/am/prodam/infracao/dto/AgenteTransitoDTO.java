package br.gov.am.prodam.infracao.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

public class AgenteTransitoDTO {

	private Long id;

	private String nome;

	@CPF
	private String cpf;

	@Email
	private String email;

	@Past
	private Date dataNascimento;

	private OrgaoAutuadorDTO orgaoAutuador;

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

	public OrgaoAutuadorDTO getOrgaoAutuador() {
		return orgaoAutuador;
	}

	public void setOrgaoAutuador(OrgaoAutuadorDTO orgaoAutuador) {
		this.orgaoAutuador = orgaoAutuador;
	}

}
