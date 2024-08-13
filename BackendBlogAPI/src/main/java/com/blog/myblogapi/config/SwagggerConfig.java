package com.blog.myblogapi.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.service.contexts.SecurityContext;

@Configuration
public class SwagggerConfig {
	private static final String AUTHORIZATION_HEADER= "Authorization";
	
	private ApiKey apikeys() {
		
		return new ApiKey("jwt", AUTHORIZATION_HEADER, "headre");
		
	}
	
	private List<SecurityReference> sf(){
		AuthorizationScope scope= new AuthorizationScope("global", "accesseverything");
		return Arrays.asList(new SecurityReference("jwt", new AuthorizationScope[] {scope}));
		
	}
	private List<SecurityContext> securityContexts(){
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}

	
	
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info()
	                        .title("Blogging Application: Backend")
	                        .description("This is a development API for blogging")
	                        .version("1.0")
	                        .termsOfService("Terms of service URL")
	                        .contact(new Contact()
	                                .name("Upendra")
	                                .url("http://google.com")
	                                .email("Upen@gmail.com"))
	                        .license(new io.swagger.v3.oas.models.info.License()
	                                .name("API License")
	                                .url("http://google.com/license")))
	                .externalDocs(new ExternalDocumentation()
	                        .description("Additional Documentation")
	                        .url("http://google.com"));
	    }
}
