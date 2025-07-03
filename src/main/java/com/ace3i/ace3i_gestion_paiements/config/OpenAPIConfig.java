package com.ace3i.ace3i_gestion_paiements.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion des Paiements - ACE3I")
                        .version("1.0.0")
                        .description("Documentation de l'API REST pour gérer les clients, factures et paiements.")
                        .contact(new Contact()
                                .name("ACE3I Dev Team")
                                .email("support@ace3i.com")
                        )
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Serveur local")
                ));
    }

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**")
                .build();
    }
}
