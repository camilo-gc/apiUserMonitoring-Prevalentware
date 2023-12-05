package com.example.apiusermonitoring.domain.spi;

import com.example.apiusermonitoring.domain.model.Country;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICountryPersistencePort {

    List<Country> findAllCountries(Pageable pageable);

}
