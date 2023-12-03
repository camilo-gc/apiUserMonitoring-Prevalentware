package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.CountryEntity;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.ICountryEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.ICountryRepository;
import com.example.apiusermonitoring.domain.model.Country;
import com.example.apiusermonitoring.domain.spi.ICountryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class CountryAdapter implements ICountryPersistencePort {

    private final ICountryRepository countryRepository;
    private final ICountryEntityMapper countryEntityMapper;

    @Override
    public List<Country> findAllCountries(Pageable pageable) {
        List<CountryEntity> countryEntityList = countryRepository.findAll(pageable).getContent();
        if (countryEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return countryEntityMapper.toCountryList(countryEntityList);
    }

}
