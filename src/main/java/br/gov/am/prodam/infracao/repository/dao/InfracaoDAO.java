package br.gov.am.prodam.infracao.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.dto.InfracaoFiltro;

public interface InfracaoDAO {

	
	public Page<Infracao> pesquisar(InfracaoFiltro filtro, Pageable pageable);
}
