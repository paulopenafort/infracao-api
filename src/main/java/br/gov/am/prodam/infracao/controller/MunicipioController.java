package br.gov.am.prodam.infracao.controller;

import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.Municipio;
import br.gov.am.prodam.infracao.dto.MunicipioDTO;
import br.gov.am.prodam.infracao.dto.MunicipioFiltro;
import br.gov.am.prodam.infracao.dto.Paginacao;
import br.gov.am.prodam.infracao.service.MunicipioService;
import io.swagger.annotations.Api;

@Component
@Path("/municipio")
@Api
public class MunicipioController extends BasicController {

	@Autowired
	private MunicipioService municipioService;

	@GET
	@Path("/pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public Page<MunicipioDTO> pesquisar(@BeanParam MunicipioFiltro filtro, @BeanParam Paginacao paginacao) {
		Page<Municipio> page = municipioService.pesquisar(filtro, paginacao.toPageable());
		return page.map(item -> map(item, MunicipioDTO.class));
	}
	
	@GET
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
	public Response salvar(@Valid MunicipioDTO dto, @Context UriInfo uriInfo) {
		Municipio municipio = map(dto, Municipio.class);
		municipioService.save(municipio);
		URI location = uriInfo.getRequestUriBuilder()
				.path(municipio.getId().toString())
				.build();
		return created("Municipio salvo com sucesso", location);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{municipioID}")
	public Response atualizar(@PathParam("municipioID") long id,  @Valid MunicipioDTO municipioDTO) {
		Municipio municipio = map(municipioDTO, Municipio.class);
		municipio.setId(id);
		municipioService.save(municipio);
		return ok("Municipio salvo com sucesso!");
		}

}
