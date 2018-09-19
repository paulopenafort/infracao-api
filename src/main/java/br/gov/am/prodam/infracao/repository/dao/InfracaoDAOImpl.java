package br.gov.am.prodam.infracao.repository.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.dto.InfracaoFiltro;

@Component
public class InfracaoDAOImpl implements InfracaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Infracao> pesquisar(InfracaoFiltro filtro) {

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

		Query query = entityManager.createQuery(jpql);

		for (Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();

	}

}
