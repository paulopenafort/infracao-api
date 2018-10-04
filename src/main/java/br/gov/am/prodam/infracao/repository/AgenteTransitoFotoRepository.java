package br.gov.am.prodam.infracao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.am.prodam.infracao.domain.AgenteTransitoFoto;

@Repository
public interface AgenteTransitoFotoRepository extends JpaRepository<AgenteTransitoFoto, Long> {
	
	

}
