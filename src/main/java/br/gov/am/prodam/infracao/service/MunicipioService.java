package br.gov.am.prodam.infracao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.repository.MunicipioRepository;

@Service
public class MunicipioService {
	
	@Autowired
	private MunicipioRepository municipioRepository;
	
	public List<Municipio> findAll(){
		return municipioRepository.findAll();
	}
	
	public Municipio salvar(Municipio municipio) {
		return municipioRepository.save(municipio);		
	}
	
	public Municipio findById(Long id) {
		return municipioRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		municipioRepository.deleteById(id);	
	}

}
