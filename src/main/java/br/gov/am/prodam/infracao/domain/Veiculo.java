package br.gov.am.prodam.infracao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
@SequenceGenerator(name = "VEICULO_GENERATOR", sequenceName = "VEICULO_SEQ", allocationSize = 1)
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEICULO_GENERATOR")
	private Long id;
	
	@Column(name = "PLACA", nullable = false, length = 8)
	private String placa;
	
	@Column(name = "RENAVAM", nullable = false, length = 15)
	private String renavam;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "COR", nullable = false)
	private String cor;
	
	@Column(name = "MARCA", nullable = false)
	private String marca;
	
	@Column(name = "ANOMODELO", nullable = false)
	private int anoModelo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
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
	
	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		return true;
	}
	
	
	

}

