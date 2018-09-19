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

import br.gov.am.prodam.infracao.domain.OrgaoAutuador;
import br.gov.am.prodam.infracao.dto.OrgaoAutuadorDTO;
import br.gov.am.prodam.infracao.service.OrgaoAutuadorService;

@Component
@Path("/orgaoAutuador")
public class OrgaoAutuadorController extends BasicController {

	@Autowired
	private OrgaoAutuadorService orgaoAutuadorService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrgaoAutuadorDTO> findAll() {

		List<OrgaoAutuador> infracoes = orgaoAutuadorService.findAll();
		
		return mapList(infracoes, OrgaoAutuadorDTO.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{orgaoAutuadorId}")
	public OrgaoAutuadorDTO findById(@PathParam("orgaoAutuadorId") Long id) {

		OrgaoAutuador orgaoAutuador = orgaoAutuadorService.findById(id).get();
		return map(orgaoAutuador, OrgaoAutuadorDTO.class);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{orgaoAutuadorId}")
	public Response delete(@PathParam("orgaoAutuadorId") Long id) {

		orgaoAutuadorService.delete(id);

		return ok("Orgão Autuador deletado com sucesso!");
	}

	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(@Valid OrgaoAutuadorDTO dto) {

		OrgaoAutuador orgaoAutuador = map(dto, OrgaoAutuador.class);

		orgaoAutuadorService.save(orgaoAutuador);

		return ok("Orgão Autuador salvo com sucesso!");
	}

}
