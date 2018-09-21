package br.gov.am.prodam.infracao.repository.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.dto.InfracaoFiltro;

@Component
public class InfracaoDAOImpl extends GenericDAO<Infracao, Long> implements InfracaoDAO {

	public Page<Infracao> pesquisar(InfracaoFiltro filtro, Pageable pageable) {

		Map<String, Object> params = new HashMap<>();

		String jpql = " select inf from Infracao inf where 1=1 ";

		if (filtro.getCompetencia() != null) {
			jpql += " and inf.competencia = :competencia";
			params.put("competencia", filtro.getCompetencia());
		}

		if (filtro.getNatureza() != null) {
			jpql += " and inf.natureza = :natureza";
			params.put("natureza", filtro.getNatureza());
		}

		if (filtro.getDescricao() != null) {
			jpql += " and upper(inf.descricao) like upper(:descricao)";
			params.put("descricao", "%" + filtro.getDescricao() + "%");
		}

		if (filtro.getTipoInfrator() != null) {
			jpql += " and inf.tipoInfrator = :tipoInfrator";
			params.put("tipoInfrator", filtro.getTipoInfrator());
		}

		return findByJPQL(jpql, params, pageable);

	}

	

}

