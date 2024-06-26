package com.vedha.service;

import com.vedha.entity.Countries;

import java.util.List;

public interface CountryService {

    List<Countries> syncCountryData();

    Countries getCountryByCode(String countryCode);
}
