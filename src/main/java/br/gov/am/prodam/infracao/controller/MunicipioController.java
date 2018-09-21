package br.gov.am.prodam.infracao.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
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

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioDTO;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;
import br.gov.am.prodam.infracao.service.MunicipioService;

@Component
@Path("/municipio")
public class MunicipioController extends BasicController {

	@Autowired
	private MunicipioService municipioService;

	@GET
	@Path("/pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MunicipioDTO> pesquisar(@BeanParam MunicipioFiltro filtro) {
		List<Municipio> municipios = municipioService.pesquisar(filtro);
		return mapList(municipios, MunicipioDTO.class);
	}
	
	@GET
	@Path("/pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MunicipioDTO> findAll() {
		List<Municipio> municipios = municipioService.findAll();
		return mapList(municipios, MunicipioDTO.class);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{municipioId}")
	public MunicipioDTO findById(@PathParam("municipioId") Long id) {
		Municipio municipio = municipioService.findById(id).get();
		return map(municipio, MunicipioDTO.class);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{municipioId}")
	public Response delete(@PathParam("municipioId") Long id) {
		municipioService.delete(id);
		return ok("Municipio deletado com sucesso");
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(@Valid MunicipioDTO dto) {
		Municipio municipio = map(dto, Municipio.class);
		municipioService.save(municipio);
		return ok("Municipio salvo com sucesso");
	}

}
