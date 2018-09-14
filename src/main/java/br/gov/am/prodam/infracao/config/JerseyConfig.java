package br.gov.am.prodam.infracao.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import br.gov.am.prodam.infracao.controller.InfracaoController;
import br.gov.am.prodam.infracao.controller.MunicipioController;

@Component
@ApplicationPath(JerseyConfig.API_VERSION)
public class JerseyConfig extends ResourceConfig {

	public static final String API_VERSION = "/api/v1";

	//@Autowired
	//private ApplicationContext appContext;



	public JerseyConfig() {
	}

	@PostConstruct
	public void setup() {
		register(InfracaoController.class);
		register(MunicipioController.class);
		property(org.glassfish.jersey.server.ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(org.glassfish.jersey.server.ServerProperties.BV_FEATURE_DISABLE, false);
	}

	/*@PostConstruct
	public void init() {

		Map<String, Object> beans = appContext.getBeansWithAnnotation(Path.class);

		for (Map.Entry<String, Object> bean : beans.entrySet()) {
			register(bean.getValue());
		}

	}*/


}