package br.gov.am.prodam.infracao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.am.prodam.infracao.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	
	public Optional<Veiculo> findByPlaca(String placa);
}
