package br.gov.am.prodam.infracao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.VeiculoFiltro;
import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.VeiculoRepository;

@Service
public class VeiculoService extends BasicService<Veiculo, Long, VeiculoRepository>  {
	
	@Override
	public Veiculo save(Veiculo veiculo) {		
		Optional<Veiculo> optVeiculo = this.repository.findByPlacaOrRenavam(veiculo.getPlaca(), veiculo.getRenavam());
		if(optVeiculo.isPresent()) {
			throw new AppException("Não foi possível salvar o veículo: "+veiculo.getPlaca());
		}
		// TODO Auto-generated method stub
		return super.save(veiculo);
	}	
	
	public List<Veiculo> pesquisar(VeiculoFiltro filtro){
		return repository.pesquisar(filtro);
	}
	
}

