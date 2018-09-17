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

import br.gov.am.prodam.infracao.domain.Infracao;
import br.gov.am.prodam.infracao.dto.InfracaoDTO;
import br.gov.am.prodam.infracao.service.InfracaoService;

@Component
@Path("/infracao")
public class InfracaoController extends BasicController {

	@Autowired
	private InfracaoService infracaoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<InfracaoDTO> findAll() {
		List<Infracao> infracoes = infracaoService.findAll();
		return mapList(infracoes, InfracaoDTO.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{infracaoId}")
	public InfracaoDTO findById(@PathParam("infracaoId") Long id) {

		Infracao infracao = infracaoService.findById(id).get();
		return map(infracao, InfracaoDTO.class);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{infracaoId}")
	public Response delete(@PathParam("infracaoId") Long id) {

		infracaoService.delete(id);

		return Response.ok().build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(@Valid InfracaoDTO dto) {

		Infracao infracao = map(dto, Infracao.class);

		infracaoService.save(infracao);

		return Response.ok().build();
	}

}