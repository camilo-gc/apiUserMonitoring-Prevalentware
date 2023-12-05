package com.example.apiusermonitoring.domain.api;

import com.example.apiusermonitoring.domain.model.Country;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICountryServicePort {

    List<Country> getAllCountries(Pageable pageable);

}
