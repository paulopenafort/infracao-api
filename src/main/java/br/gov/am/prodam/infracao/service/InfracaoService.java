package br.gov.am.prodam.infracao.service;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.repository.InfracaoRepository;

@Service
public class InfracaoService extends BasicService<Infracao, Long, InfracaoRepository> {

}
