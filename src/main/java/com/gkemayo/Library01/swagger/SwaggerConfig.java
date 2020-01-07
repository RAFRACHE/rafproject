package com.gkemayo.Library01.swagger;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  //On commence alors par initialiser un objet Docket en précisant que nous souhaitons utiliser swagger 2.
                .select()//permet d'initialiser une classe du nom de ApiSelectorBuilder qui donne accès aux méthodes de personnalisation suivantes
                .apis(RequestHandlerSelectors.basePackage("com.gkemayo.Library01"))  //() Elle permet de filtrer la documentation à exposer selon les contrôleurs.
                .paths(PathSelectors.any()) //est un prédicat (introduit depuis java 8) qui permet de retourner TRUE ou FALSE selon la conditions utilisée
                .build() //cette méthode donne accès à une autre façon de filtrer : selon l'URI des requêtes. Ainsi, vous pouvez, par exemple,
                // demander à Swagger de ne documenter que les méthodes qui répondent à des requêtes commençant par "/public" .
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Library Spring Boot REST API Documentation")
                .description("REST APIs For Managing Books loans in a Library")
                .contact(new Contact("Amoura mohand-rachid", "https://gkemayo.developpez.com/", "rafraf19@gmail.com"))
                .version("1.0")
                .build();

    }
}
