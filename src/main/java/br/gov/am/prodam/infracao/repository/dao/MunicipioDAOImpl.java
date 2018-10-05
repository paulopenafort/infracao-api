package br.gov.am.prodam.infracao.repository.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;

@Component
public class MunicipioDAOImpl extends GenericDAO<Municipio, Long> implements MunicipioDAO{

	@PersistenceContext
	private EntityManager entity;
	

	@Override
	public Page<Municipio> pesquisar(MunicipioFiltro filtro, Pageable pageable) {
		StringBuilder sql = new StringBuilder("select cidade from Municipio cidade where 1=1 ");
		Map<String, Object> map = new HashMap<>();
		
				
		if (filtro.getNome() != null) {
			sql.append("and cidade.nome = :nome");
			map.put("nome", filtro.getNome());
		}
		
		if (filtro.getDescricao() != null) {
			sql.append("and cidade.descricao = :descricao");
			map.put("descricao", filtro.getDescricao());
		}
		
		TypedQuery<Municipio> query = entity.createQuery(sql.toString(), Municipio.class);

		for (Map.Entry<String, Object> param : map.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return findByJPQL(sql.toString(), map, pageable);
	}


	

}
