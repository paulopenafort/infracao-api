package br.gov.am.prodam.infracao.service;


import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;
import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.MunicipioRepository;

@Service
public class MunicipioService extends BasicService<Municipio, Long, MunicipioRepository> {
	
	@Override
	public Municipio save(Municipio municipio) {
		if (municipio.getNome().equals(null)) {
			throw new AppException("Não pode haver municipio de nome 'null");
		}
		
		return super.save(municipio);
	}
	
	public List<Municipio> pesquisar(MunicipioFiltro filtro) {
		return repository.pesquisar(filtro);
//		return  br.gov.am.prodam.infracao.repository.dao.MunicipioDAO.pesquisar(filtro);



	}

}
