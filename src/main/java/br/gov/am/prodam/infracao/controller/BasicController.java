package br.gov.am.prodam.infracao.controller;

import java.util.List;

import org.modelmapper.PropertyMap;

import br.gov.am.prodam.infracao.util.Util;

public class BasicController {

	public static <TO, DTO> List<DTO> mapList(List<TO> lista, Class<DTO> classDTO, PropertyMap<TO, DTO> propertyMap) {

		return Util.buildListDTO(lista, classDTO, propertyMap);
	}

	public static <TO, DTO> List<DTO> mapList(List<TO> lista, Class<DTO> classDTO) {
		return mapList(lista, classDTO, null);
	}

	public static <TO, DTO> DTO map(TO obj, Class<DTO> classDTO, PropertyMap<TO, DTO> propertyMap) {
		return Util.buildDTO(obj, classDTO, propertyMap);
	}

	public static <TO, DTO> DTO map(TO obj, Class<DTO> classDTO) {
		return map(obj, classDTO, null);
	}

}
