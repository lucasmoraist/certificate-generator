package com.lucas.certificategenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class DocumentationConfig {
    
    @Bean
    public OpenAPI documentationApi(){
        return new OpenAPI()
            .info(new Info()
                .title("Certificate Generator")
                .description("API crianda durante a Next Level Week da Rocketseat, que tem como objetivo enviar certificados quando os alunos cadastrados atingeram uma quantidade de respostas corretas.")
                .summary("V1")
                .contact(new Contact()
                    .name("Lucas de Morais Nascimento Taguchi")
                    .email("luksmnt1101@gmail.com")
                )
                .license(new License()
                    .name("MIT License")
                    .url("https://github.com/lucasmoraist/certificate-generator/blob/main/LICENSE")
                )
            );
    }

}
