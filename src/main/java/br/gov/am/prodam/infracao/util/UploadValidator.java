package br.gov.am.prodam.infracao.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.tika.Tika;

public class UploadValidator {

	private List<String> extensoes = new ArrayList<>();

	public static enum ContentType {

		SVG("image/svg+xml"),
		PNG("image/png"),
		XLS("application/vnd.ms-excel",
			"application/vnd.oasis.opendocument.presentation", 
			"application/vnd.oasis.opendocument.spreadsheet",
			"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
		JPG("image/jpeg","image/jpg"), 
		DOC("application/msword", 
			"application/rtf",
			"application/vnd.oasis.opendocument.text"),
		PPT("application/vnd.ms-powerpoint",
			"application/vnd.oasis.opendocument.presentation"), 
		PDF("application/pdf");

		private List<String> contentType;

		private ContentType(String... contentType) {

			this.contentType = Arrays.asList(contentType);
		}

		public List<String> getContentType() {
			return contentType;
		}

	}

	public static UploadValidator create() {
		return new UploadValidator();
	}

	public static UploadValidator create(String extensao) {
		return new UploadValidator().permit(extensao);
	}

	public static UploadValidator create(ContentType contentType) {
		return new UploadValidator().permit(contentType);
	}

	public UploadValidator permit(ContentType contentType) {

		List<String> lista = contentType.getContentType();

		for (String cont : lista) {
			permit(cont);
		}

		return this;
	}

	public UploadValidator permit(String extensao) {

		if (extensao == null) {
			throw new IllegalArgumentException("Informe uma extensão");
		}

		
		extensoes.add(extensao);
		return this;
	}
	
	public boolean isInvalid(byte[] bytes) {
		return !isValid(bytes);
	}

	public boolean isValid(byte[] bytes) {
		Tika tika = new Tika();

		String contentType = tika.detect(bytes);

		return this.extensoes.contains(contentType);
		
		
	}

}
