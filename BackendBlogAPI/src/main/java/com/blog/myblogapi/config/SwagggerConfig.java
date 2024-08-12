package com.blog.myblogapi.config;

import org.hibernate.mapping.Collection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.VendorExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import io.jsonwebtoken.lang.Collections;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwagggerConfig {

	  @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(createApiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.blog.myblogapi"))  // Specify your base package
	                .paths(PathSelectors.any())
	                .build();
	    }

	  private ApiInfo createApiInfo() {
	        return new ApiInfo(
	                "Blogging Application: Backend",
	                "This is a development API for blogging",
	                "1.0",
	                "Terms of service URL",
	                new Contact("Upendra", "http://google.com", "Upen@gmail.com"),
	                "API License",
	                "http://google.com/license",
	                
	                Collections.arrayToList(null));
	    }
}
