package br.gov.am.prodam.infracao.service;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.InfracaoRepository;

@Service
public class InfracaoService extends BasicService<Infracao, Long, InfracaoRepository> {
	
	@Override
	public Infracao save(Infracao infracao) {
		
		if (infracao.getDescricao().equals("123")) {
			throw new AppException("Não possivel salvar com descricao 123", "ERRO001");
		}
		
		
		return super.save(infracao);
	}

}
