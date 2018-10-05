package br.gov.am.prodam.infracao.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;

public interface MunicipioDAO {
	
	public Page<Municipio> pesquisar(MunicipioFiltro filtro, Pageable pageable);
	
}
