package br.gov.am.prodam.infracao.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import br.gov.am.prodam.infracao.exception.AppExceptionMapper;
import br.gov.am.prodam.infracao.filter.CORSFilter;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
@ApplicationPath(JerseyConfig.API_VERSION)
public class JerseyConfig extends ResourceConfig {

	public static final String API_VERSION = "/api/v1";
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@Value("${spring.jersey.application-path:"+API_VERSION+"}")
	private String apiPath;


	public JerseyConfig() {
	}

	@PostConstruct
	public void setup() {
		configJersey();
		registerControllers();
		configureSwagger();
	}

	public void configJersey() {
		
		register(AppExceptionMapper.class);
		register(CORSFilter.class);
		
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_FEATURE_DISABLE, false);
	}

	public void registerControllers() {
		appContext.getBeansWithAnnotation(Path.class).forEach((name, bean) -> register(bean));
	}
	
	
	private void configureSwagger() {
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setTitle("SCIT - Restful API");
		config.setVersion("v1");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath(this.apiPath);
		config.setResourcePackage("br.gov.am.prodam.infracao.controller");
		config.setPrettyPrint(true);
		config.setScan(true);
	}

}