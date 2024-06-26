package com.vedha.config;

import com.vedha.entity.Countries;
import com.vedha.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AppRunnerConfig implements CommandLineRunner {

    private final CountryService countryService;

    @Override
    public void run(String... args) {

        List<Countries> countries = countryService.syncCountryData();
        log.info("Countries data loaded: {}", countries.size());
    }
}
