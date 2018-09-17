package br.gov.am.prodam.infracao.service;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.repository.VeiculoRepository;

@Service
public class VeiculoService extends BasicService<Veiculo, Long, VeiculoRepository> {

}
