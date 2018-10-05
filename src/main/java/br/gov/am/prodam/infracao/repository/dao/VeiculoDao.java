package br.gov.am.prodam.infracao.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.VeiculoFiltro;

public interface VeiculoDao {
	
	
	public Page<Veiculo> pesquisar(VeiculoFiltro filtro, Pageable pageable); 


}
