package br.gov.am.prodam.infracao.repository.dao;

import java.util.List;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.dto.InfracaoFiltro;

public interface InfracaoDAO {

	
	public List<Infracao> pesquisar(InfracaoFiltro filtro);
}
