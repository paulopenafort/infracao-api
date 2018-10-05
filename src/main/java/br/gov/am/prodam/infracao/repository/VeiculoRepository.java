package br.gov.am.prodam.infracao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.repository.dao.VeiculoDao;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, VeiculoDao {

	public Optional<Veiculo> findByPlacaOrRenavam(String placa, String Renavam);

	@Query("select v from Veiculo v where (v.placa = :placa or v.renavam = :renavam) and v.id <> :id")
	public Optional<Veiculo> findByPlacaOrRenavam(@Param("placa") String placa,
			@Param("renavam") String Renavam, @Param("id") Long exclui);

}
