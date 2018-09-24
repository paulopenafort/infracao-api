package br.gov.am.prodam.infracao.service;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import br.gov.am.prodam.infracao.domain.AgenteTransitoFoto;
import br.gov.am.prodam.infracao.exception.AppException;
import br.gov.am.prodam.infracao.repository.AgenteTransitoFotoRepository;
import br.gov.am.prodam.infracao.util.UploadValidator;
import br.gov.am.prodam.infracao.util.UploadValidator.ContentType;

@Service
public class AgenteTransitoFotoService extends BasicService<AgenteTransitoFoto, Long, AgenteTransitoFotoRepository> {
	
	
	/*@Override
	public AgenteTransitoFoto save(AgenteTransitoFoto agFoto) {
		
		
		boolean invalido = UploadValidator.create()
		.permit(ContentType.PNG)
		.isInvalid(agFoto.getFoto());
		
		if (invalido) {
			throw new AppException("Foto está no formato inválido");
		}
		
		return super.save(agFoto);
	}*/
	
	
	public AgenteTransitoFoto save(AgenteTransitoFoto agFoto) {
		
		boolean invalid = UploadValidator.create()
			.permit(ContentType.PNG)
			.permit(ContentType.PDF)
			.isInvalid(agFoto.getFoto());
		
		
		
		if (invalid) {
			throw new AppException("Foto está no formato inválido");
		}
		
		return super.save(agFoto);
	}

}
