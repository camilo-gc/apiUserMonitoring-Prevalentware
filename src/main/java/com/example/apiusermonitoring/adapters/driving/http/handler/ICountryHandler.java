package com.example.apiusermonitoring.adapters.driving.http.handler;

import com.example.apiusermonitoring.adapters.driving.http.dto.response.CountryResponseDto;

import java.util.List;

public interface ICountryHandler {

    List<CountryResponseDto> getCountries(int page, int size);

}
