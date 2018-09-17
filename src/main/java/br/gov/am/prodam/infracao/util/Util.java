package br.gov.am.prodam.infracao.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public final class Util {

	public static final Integer ZERO = Integer.valueOf(0);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	public static ModelMapper getModelMapper() {
		return MODEL_MAPPER;
	}

	public static boolean isNull(Number valor) {
		return ((valor == null) || (ZERO.equals(valor)));
	}

	public static boolean isNotNull(Number valor) {
		return !isNull(valor);
	}

	public static boolean isNull(String valor) {
		return ((valor == null) || (valor.trim().isEmpty()));
	}

	public static boolean isNotNull(String valor) {
		return !isNull(valor);
	}

	public static boolean isNull(Character valor) {
		return ((valor == null) || (Character.isWhitespace(valor.charValue())));
	}

	public static boolean isNotNull(Character valor) {
		return !isNull(valor);
	}

	public static boolean isNull(List<?> lista) {
		return lista == null || lista.isEmpty();
	}

	public static boolean isNotNull(List<?> lista) {
		return !isNull(lista);
	}

	public static <TO, DTO> List<DTO> mapList(List<TO> lista, Class<DTO> classDTO,
			PropertyMap<TO, DTO> propertyMap) {

		ArrayList<DTO> listaDTO = new ArrayList<>();

		if (!lista.isEmpty()) {
			for (TO obj : lista) {
				listaDTO.add(map(obj, classDTO, propertyMap));
			}
		}

		return listaDTO;
	}

	public static <TO, DTO> List<DTO> buildListDTO(List<TO> lista, Class<DTO> classDTO) {
		return mapList(lista, classDTO, null);
	}

	public static <TO, DTO> DTO map(TO obj, Class<DTO> classDTO, PropertyMap<TO, DTO> propertyMap) {

		if (obj == null) {
			return null;
		}

		if (propertyMap != null && MODEL_MAPPER.getTypeMap(obj.getClass(), classDTO) == null) {
			MODEL_MAPPER.addMappings(propertyMap);
		}

		return MODEL_MAPPER.map(obj, classDTO);

	}

	public static <TO, DTO> DTO map(TO obj, Class<DTO> classDTO) {
		return map(obj, classDTO, null);
	}

	public static String formatarNumeroAuto(Long numeroAuto) {
		String retorno = "00000000";
		if (Util.isNotNull(numeroAuto)) {
			retorno = String.format("%08d", numeroAuto);
		}
		return retorno;
	}

}
