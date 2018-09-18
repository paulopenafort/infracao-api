package br.gov.am.prodam.infracao.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.VeiculoRepository;

@Service
public class VeiculoService extends BasicService<Veiculo, Long, VeiculoRepository>  {
	
	@Override
	public Veiculo save(Veiculo veiculo) {
		
		Optional<Veiculo> optVeiculo = this.repository.findByPlaca(veiculo.getPlaca());
		if(optVeiculo.isPresent()) {
			throw new AppException("Não foi possível salvar o veículo: "+veiculo.getPlaca());
		}
		// TODO Auto-generated method stub
		return super.save(veiculo);
	}	
	
}
