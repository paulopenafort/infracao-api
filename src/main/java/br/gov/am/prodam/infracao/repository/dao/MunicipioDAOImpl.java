package br.gov.am.prodam.infracao.repository.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;

@Component
public class MunicipioDAOImpl implements MunicipioDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Municipio> pesquisar(MunicipioFiltro filtro) {
		
		Map<String, Object> params = new HashMap<>(); 
		
		String jpql = " select cidade from Municipio cidade where 1=1 ";
		
		if (filtro.getNome() != null) {
			jpql += "and cidade.nome = :nome";
		}
		
		if (filtro.getDescricao() != null) {
			jpql += "and cidade.descricao = :descricao";
		}
		
		Query query = entityManager.createQuery(jpql);
		for (Map.Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return query.getResultList();
	}

}
