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

import br.gov.am.prodam.infracao.domain.AgenteTransito;
import br.gov.am.prodam.infracao.dto.AgenteTransitoDTO;
import br.gov.am.prodam.infracao.service.AgenteTransitoService;

@Component
@Path("/agenteTransito")
public class AgenteTransitoController extends BasicController {

	@Autowired
	private AgenteTransitoService agenteTransitoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AgenteTransitoDTO> findAll() {

		List<AgenteTransito> infracoes = agenteTransitoService.findAll();

		return mapList(infracoes, AgenteTransitoDTO.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{agenteTransitoId}")
	public AgenteTransitoDTO findById(@PathParam("agenteTransitoId") Long id) {

		AgenteTransito agenteTransito = agenteTransitoService.findById(id).get();
		return map(agenteTransito, AgenteTransitoDTO.class);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{agenteTransitoId}")
	public Response delete(@PathParam("agenteTransitoId") Long id) {

		agenteTransitoService.delete(id);

		return ok("Orgão Autuador deletado com sucesso!");
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(@Valid AgenteTransitoDTO dto) {

		AgenteTransito agenteTransito = map(dto, AgenteTransito.class);

		agenteTransitoService.save(agenteTransito);

		return ok("Orgão Autuador salvo com sucesso!");
	}

}
