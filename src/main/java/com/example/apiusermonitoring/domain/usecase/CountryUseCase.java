package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.domain.api.ICountryServicePort;
import com.example.apiusermonitoring.domain.model.Country;
import com.example.apiusermonitoring.domain.spi.ICountryPersistencePort;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CountryUseCase implements ICountryServicePort {

    private final ICountryPersistencePort countryPersistencePort;

    public CountryUseCase(ICountryPersistencePort countryPersistencePort) {
        this.countryPersistencePort = countryPersistencePort;
    }

    @Override
    public List<Country> getAllCountries(Pageable pageable) {
        return countryPersistencePort.findAllCountries(pageable);
    }

}
