package br.gov.am.prodam.infracao.repository.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.VeiculoFiltro;

@Component
public class VeiculoDaoImpl extends GenericDAO<Veiculo,	Long> implements VeiculoDao {

	@PersistenceContext
	private EntityManager entity;

	@Override
	public Page<Veiculo> pesquisar(VeiculoFiltro filtro, Pageable pageable) {
		StringBuilder sql = new StringBuilder("select vcl from Veiculo vcl where 1=1 ");
		Map<String, Object> map = new HashMap<>();

		if (filtro.getAnoModelo() > 0) {
			sql.append(" and vcl.anoModelo = :anomodelo");
			map.put("anomodelo", filtro.getAnoModelo());
		}

		// continue daqui
		if (filtro.getCor() != null) {
			sql.append(" and vcl.cor = :cor");
			map.put("cor", filtro.getCor());
		}

		if (filtro.getNome() != null) {
			sql.append(" and vcl.nome = :nome");
			map.put("nome", filtro.getNome());
		}

		if (filtro.getMarca() != null) {
			sql.append(" and vcl.marca = :marca");
			map.put("marca", filtro.getMarca());
		}

		TypedQuery<Veiculo> query = entity.createQuery(sql.toString(), Veiculo.class);

		for (Map.Entry<String, Object> param : map.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return findByJPQL(sql.toString(), map, pageable);
	}

}
