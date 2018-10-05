package br.gov.am.prodam.infracao.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;
import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.MunicipioRepository;

@Service
public class MunicipioService extends BasicService<Municipio, Long, MunicipioRepository> {
	
	@Override
	public Municipio save(Municipio municipio) {
		if (municipio.getNome().equals(null)) {
			throw new AppException("Não pode haver municipio de nome 'null");
		}
		
		return super.save(municipio);
	}
	
	public Page<Municipio> pesquisar(MunicipioFiltro filtro, Pageable pageable) {
		return repository.pesquisar(filtro, pageable);
	}

}
