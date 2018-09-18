package br.gov.am.prodam.infracao.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.VeiculoDTO;
import br.gov.am.prodam.infracao.service.VeiculoService;

@Component
@Path("/veiculo")
public class VeiculoController extends BasicController {
	@Autowired
	private VeiculoService veiculoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VeiculoDTO> findAll() {
		List<Veiculo> veiculos = veiculoService.findAll();
		return BasicController.mapList(veiculos, VeiculoDTO.class);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(@Valid VeiculoDTO veiculoDTO) {
		Veiculo veiculo = map(veiculoDTO, Veiculo.class);
		veiculoService.save(veiculo);
		return ok("Veículo salvo com sucesso!");
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{veiculoID}")
	public Response apagarVeiculo(@PathParam("veiculoID") long id) {
		veiculoService.delete(id);
		return ok("Veículo deletado com sucesso!");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public VeiculoDTO localizarPorID(@PathParam("id") Long id) {
		Veiculo veiculo = veiculoService.findById(id).get();
		return map(veiculo, VeiculoDTO.class);
	}

}
