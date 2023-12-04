package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.databuilder.CountryDataBuilder;
import com.example.apiusermonitoring.domain.api.ICountryServicePort;
import com.example.apiusermonitoring.domain.model.Country;
import com.example.apiusermonitoring.domain.spi.ICountryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryUseCaseTest {

    private ICountryPersistencePort countryPersistencePort;
    private ICountryServicePort countryServicePort;

    @BeforeEach
    void setUp() {
        countryPersistencePort = mock(ICountryPersistencePort.class);
        countryServicePort = new CountryUseCase(countryPersistencePort);
    }

    @Test
    void testGetAllCountries() {

        List<Country> countryList = CountryDataBuilder.buildList(5);

        when(countryPersistencePort.findAllCountries(any(Pageable.class))).thenReturn(countryList);
        assertEquals(countryList, countryServicePort.getAllCountries(Pageable.unpaged()));
        verify(countryPersistencePort, times(1)).findAllCountries(any(Pageable.class));

    }

    @Test
    void testGetAllCountriesWithNoCountries() {

        Pageable pageable = PageRequest.of( 0, 10, Sort.by(Sort.Direction.ASC, "name") );

        doThrow(NoDataFoundException.class).when(countryPersistencePort).findAllCountries(pageable);
        assertThrows(NoDataFoundException.class, () -> countryServicePort.getAllCountries(pageable));

    }

}