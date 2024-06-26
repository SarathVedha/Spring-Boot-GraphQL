package com.vedha.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    GraphQlClient graphQlClient() {

        // Create a GraphQL client with the URL of the GraphQL server
        // to connect to and a WebClient instance to use for the HTTP communication.
        return HttpGraphQlClient
                .builder(WebClient.builder().build())
                .url("https://countries.trevorblades.com/graphql")
                .build();
    }
}
