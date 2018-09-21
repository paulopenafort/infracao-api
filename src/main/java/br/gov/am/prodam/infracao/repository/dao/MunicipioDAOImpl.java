package br.gov.am.prodam.infracao.repository.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;

@Component
public class MunicipioDAOImpl extends GenericDAO<Municipio, Long> implements MunicipioDAO{

		
	@Override
	public Page<Municipio> pesquisar(MunicipioFiltro filtro, Pageable pageable) {
		
		Map<String, Object> params = new HashMap<>(); 
		
		String jpql = " select cidade from Municipio cidade where 1=1 ";
		
		if (filtro.getNome() != null) {
			jpql += "and cidade.nome = :nome";
			params.put("cidade", filtro.getNome());
		}
		
		if (filtro.getDescricao() != null) {
			jpql += "and cidade.descricao = :descricao";
			params.put("descricao", filtro.getDescricao());
		}
		
		
		return findByJPQL(jpql, params, pageable);
	}

}
