package com.vedha.service.impl;

import com.vedha.entity.Countries;
import com.vedha.repository.CountryRepository;
import com.vedha.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final GraphQlClient graphQlClient;

    @Override
    public List<Countries> syncCountryData() {

        log.info("Syncing country data");

        String query = """
                query {
                    countries {
                        name
                        code
                        capital
                        currency
                        awsRegion
                    }
                }""";

        log.warn("query: {}", query);

        Mono<List<Countries>> listMono = graphQlClient.document(query)
                .retrieve("countries")
                .toEntityList(Countries.class);

        List<Countries> countries = listMono.blockOptional().orElseThrow(() -> new RuntimeException("Failed to fetch country data"));

        log.info("Fetched {} countries from the server", countries.size());

        return countryRepository.saveAll(countries);
    }

    @Override
    public Countries getCountryByCode(String countryCode) {

        String queryByCountryCode = """
                query($code: ID!) {
                    country(code: $code) {
                        name
                        code
                        capital
                        currency
                        awsRegion
                    }
                }
                """;

        log.warn("queryByCountryCode: {}", queryByCountryCode);

        Mono<Countries> countriesMono = graphQlClient.document(queryByCountryCode).variable("code", countryCode).retrieve("country").toEntity(Countries.class);

        Countries fetchCountryData = countriesMono.blockOptional().orElseThrow(() -> new RuntimeException("Failed to fetch country data"));
        log.info("Fetched country data: {}", fetchCountryData);

        return fetchCountryData;
    }
}
