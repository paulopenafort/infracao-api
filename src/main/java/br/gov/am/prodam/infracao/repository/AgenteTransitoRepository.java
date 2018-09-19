package br.gov.am.prodam.infracao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.am.prodam.infracao.domain.AgenteTransito;
import br.gov.am.prodam.infracao.domain.OrgaoAutuador;

@Repository
public interface AgenteTransitoRepository extends JpaRepository<AgenteTransito, Long> {
	
	
	public List<AgenteTransito> findByOrgaoAutuador(OrgaoAutuador orgaoAutuador);

}
