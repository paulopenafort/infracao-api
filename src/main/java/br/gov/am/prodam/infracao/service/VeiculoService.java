package br.gov.am.prodam.infracao.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.VeiculoFiltro;

import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.VeiculoRepository;

@Service
public class VeiculoService extends BasicService<Veiculo, Long, VeiculoRepository>  {
	

	public Veiculo save(Veiculo veiculo) {
		
		Optional<Veiculo> optVeiculo = null;
		
		if(veiculo.getId()!=null) {
			 optVeiculo = this.repository.findByPlacaOrRenavam(veiculo.getPlaca(), veiculo.getRenavam(), veiculo.getId());
		} else {
			optVeiculo = this.repository.findByPlacaOrRenavam(veiculo.getPlaca(), veiculo.getRenavam());
		}
		if(optVeiculo.isPresent()) {
			throw new AppException("Não foi possível salvar o veículo: "+veiculo.getPlaca());
		}
		// TODO Auto-generated method stub
		return super.save(veiculo);
	}	
	
	public Page<Veiculo> pesquisar(VeiculoFiltro filtro, Pageable pageable){
		return repository.pesquisar(filtro, pageable);
	}

}
