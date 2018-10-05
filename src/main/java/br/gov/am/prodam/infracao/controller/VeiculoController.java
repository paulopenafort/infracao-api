package br.gov.am.prodam.infracao.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.am.prodam.infracao.domain.Veiculo;
import br.gov.am.prodam.infracao.dto.Paginacao;
import br.gov.am.prodam.infracao.dto.VeiculoDTO;
import br.gov.am.prodam.infracao.dto.VeiculoFiltro;
import br.gov.am.prodam.infracao.service.VeiculoService;
import io.swagger.annotations.Api;

@Component
@Path("/veiculo")
@Api
public class VeiculoController extends BasicController {
	@Autowired
	private VeiculoService veiculoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VeiculoDTO> findAll() {
		List<Veiculo> veiculos = veiculoService.findAll();
		return mapList(veiculos, VeiculoDTO.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pesquisar")
	public Page<VeiculoDTO> pesquisa(@BeanParam VeiculoFiltro filtro, @BeanParam Paginacao paginacao) {

		Page<Veiculo> page = veiculoService.pesquisar(filtro, paginacao.toPageable());
		return page.map(item -> map(item, VeiculoDTO.class));
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(@Valid VeiculoDTO veiculoDTO) {
		Veiculo veiculo = map(veiculoDTO, Veiculo.class);
		veiculoService.save(veiculo);
		return ok("Veículo salvo com sucesso!");
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{veiculoID}")
	public Response atualizar(@PathParam("veiculoID") long id,  @Valid VeiculoDTO veiculoDTO) {
		Veiculo veiculo = map(veiculoDTO, Veiculo.class);
		veiculo.setId(id);
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

	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	public Response apagarVeiculos(List<Long> id) {
		Long ids;
		Iterator<Long> idsIterator = id.iterator();
		while (idsIterator.hasNext()) {		
			ids = idsIterator.next();
			apagarVeiculo(ids);			
		}
		return ok("Veículos deletados com sucesso!");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public VeiculoDTO localizarPorID(@PathParam("id") Long id) {
		Veiculo veiculo = veiculoService.findById(id).get();
		return map(veiculo, VeiculoDTO.class);
	}

}
