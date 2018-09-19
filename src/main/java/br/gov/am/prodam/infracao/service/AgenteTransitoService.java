package br.gov.am.prodam.infracao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.AgenteTransito;
import br.gov.am.prodam.infracao.domain.OrgaoAutuador;
import br.gov.am.prodam.infracao.repository.AgenteTransitoRepository;

@Service
public class AgenteTransitoService extends BasicService<AgenteTransito, Long, AgenteTransitoRepository> {
	
	
	public List<AgenteTransito> findByOrgaoAutuador(OrgaoAutuador orgaoAutuador) {
		
		return repository.findByOrgaoAutuador(orgaoAutuador);
	}

}
