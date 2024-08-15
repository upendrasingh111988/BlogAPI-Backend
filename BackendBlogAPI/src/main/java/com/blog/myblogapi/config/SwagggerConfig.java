package com.blog.myblogapi.config;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;

@Configuration
public class SwagggerConfig {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Blogging Application API")
                                .description("API documentation for Blogging application")
                                .version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                            .scheme("bearer")
                                            .bearerFormat("JWT")));
    }
}
