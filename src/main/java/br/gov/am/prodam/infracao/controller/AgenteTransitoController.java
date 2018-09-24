package br.gov.am.prodam.infracao.controller;

import java.io.IOException;
import java.io.InputStream;
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

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.domain.AgenteTransito;
import br.gov.am.prodam.infracao.domain.AgenteTransitoFoto;
import br.gov.am.prodam.infracao.dto.AgenteTransitoDTO;
import br.gov.am.prodam.infracao.service.AgenteTransitoFotoService;
import br.gov.am.prodam.infracao.service.AgenteTransitoService;

@Component
@Path("/agenteTransito")
public class AgenteTransitoController extends BasicController {

	@Autowired
	private AgenteTransitoService agenteTransitoService;

	@Autowired
	private AgenteTransitoFotoService agenteTransitoFotoService;

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

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idAgenteTransito}/foto")
	public Response salvarFoto(
				@PathParam("idAgenteTransito") Long idAgenteTransito,
				@FormDataParam("foto") FormDataBodyPart body
	) throws IOException {

		AgenteTransitoFoto agFoto = new AgenteTransitoFoto();

		byte[] foto = body.getEntityAs(byte[].class);

		agFoto.setAgente(new AgenteTransito(idAgenteTransito));
		
		agFoto.setNome(body.getName());
		agFoto.setTipo(body.getMediaType().toString());
		agFoto.setFoto(foto);

		agenteTransitoFotoService.save(agFoto);

		return ok("Foto do agente salva com sucesso!");
	}

	@GET
	@Path("{id}/foto/{idFoto}")
	public Response getFoto(@PathParam("id") Long id, @PathParam("idFoto") Long idFoto) throws IOException {

		AgenteTransitoFoto agFoto = agenteTransitoFotoService.findById(idFoto).get();

		return Response
				.ok(agFoto.getFoto()).type(agFoto.getTipo())
				.header("Content-Disposition", "attachment; filename=\"" + agFoto.getNome() + "\"").build();
	}

}
