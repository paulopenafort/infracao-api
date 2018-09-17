package br.gov.am.prodam.infracao.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath(JerseyConfig.API_VERSION)
public class JerseyConfig extends ResourceConfig {

	public static final String API_VERSION = "/api/v1";
	

	@Autowired
	private ApplicationContext appContext;

	public JerseyConfig() {
	}

	@PostConstruct
	public void setup() {
		configJersey();
		registerControllers();
	}

	public void configJersey() {
		
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_FEATURE_DISABLE, false);
	}

	public void registerControllers() {
		appContext.getBeansWithAnnotation(Path.class).forEach((name, bean) -> register(bean));
	}

}