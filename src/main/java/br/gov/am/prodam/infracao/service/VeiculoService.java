package br.gov.am.prodam.infracao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<Veiculo> findAllVeiculos() {
		
		return veiculoRepository.findAll();
	}	
	
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public Veiculo findVeiculoById(Long id) {
		
		return veiculoRepository.findById(id).get();
	}
	
	public void deleteVeiculo(Long id) {
		veiculoRepository.deleteById(id);
	}
	

}
