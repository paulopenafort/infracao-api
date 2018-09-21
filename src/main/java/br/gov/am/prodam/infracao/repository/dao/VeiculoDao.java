package br.gov.am.prodam.infracao.repository.dao;

import java.util.List;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.VeiculoFiltro;

public interface VeiculoDao {
	
	public List<Veiculo> pesquisar(VeiculoFiltro filtro); 

}
