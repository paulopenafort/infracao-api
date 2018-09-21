package br.gov.am.prodam.infracao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.repository.dao.InfracaoDAO;

@Repository
public interface InfracaoRepository extends JpaRepository<Infracao, Long>, InfracaoDAO {
	
	
	public List<Infracao> findByCompetencia(String competencia, Pageable pageable);

}
