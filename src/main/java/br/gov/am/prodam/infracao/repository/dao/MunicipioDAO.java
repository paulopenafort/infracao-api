package br.gov.am.prodam.infracao.repository.dao;

import java.util.List;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;

public interface MunicipioDAO {
	
	public List<Municipio> pesquisar(MunicipioFiltro filtro);
	
}
