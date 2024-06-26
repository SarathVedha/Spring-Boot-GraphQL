package com.vedha.repository;

import com.vedha.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Countries, Long> {
}
