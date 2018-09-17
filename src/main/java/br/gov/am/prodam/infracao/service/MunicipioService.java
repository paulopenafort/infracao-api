package br.gov.am.prodam.infracao.service;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.repository.MunicipioRepository;

@Service
public class MunicipioService extends BasicService<Municipio, Long, MunicipioRepository> {

}
