package com.example.apiusermonitoring.adapters.driving.http.handler.impl;

import com.example.apiusermonitoring.adapters.driving.http.dto.response.CountryResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.ICountryHandler;
import com.example.apiusermonitoring.adapters.driving.http.mapper.ICountryResponseMapper;
import com.example.apiusermonitoring.domain.api.ICountryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryHandlerImpl implements ICountryHandler {

    private final ICountryServicePort countryServicePort;
    private final ICountryResponseMapper countryResponseMapper;

    @Override
    public List<CountryResponseDto> getCountries(int page, int size) {
        Pageable pageable = PageRequest.of( page-1, size, Sort.by(Sort.Direction.ASC, "name"));
        return countryResponseMapper.toResponseList( countryServicePort.getAllCountries(pageable) );
    }

}
