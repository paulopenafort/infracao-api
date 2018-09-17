package br.gov.am.prodam.infracao.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import org.modelmapper.PropertyMap;

import br.gov.am.prodam.infracao.dto.Resposta;
import br.gov.am.prodam.infracao.util.Util;

public class BasicController {

	public static <TO, DTO> List<DTO> mapList(List<TO> lista, Class<DTO> classDTO, PropertyMap<TO, DTO> propertyMap) {

		return Util.mapList(lista, classDTO, propertyMap);
	}

	public static <TO, DTO> List<DTO> mapList(List<TO> lista, Class<DTO> classDTO) {
		return mapList(lista, classDTO, null);
	}

	public static <TO, DTO> DTO map(TO obj, Class<DTO> classDTO, PropertyMap<TO, DTO> propertyMap) {

		return Util.map(obj, classDTO, propertyMap);

	}

	public static <TO, DTO> DTO map(TO obj, Class<DTO> classDTO) {
		return map(obj, classDTO, null);
	}
	
	public Response ok(String mensagem) {
		return Response.ok(new Resposta(mensagem, true)).build();
	}

}
