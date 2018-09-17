package br.gov.am.prodam.infracao.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.gov.am.prodam.infracao.dto.Resposta;

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {

	@Override
	public Response toResponse(AppException exc) {

		return Response.status(Status.BAD_REQUEST)
				.entity(new Resposta(exc.getMensagem(), exc.getErro(), false))
				.build();
	}

}
