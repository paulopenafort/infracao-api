package br.gov.am.prodam.infracao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.repository.InfracaoRepository;

@Service
public class InfracaoService {

	@Autowired
	private InfracaoRepository infracaoRepository;

	public List<Infracao> findAll() {
		return infracaoRepository.findAll();
	}

	public Infracao salvar(Infracao infracao) {
		return infracaoRepository.save(infracao);
	}

	public Infracao findById(Long id) {
		return infracaoRepository.findById(id).get();
	}

	public void delete(Long id) {
		infracaoRepository.deleteById(id);
	}

}
