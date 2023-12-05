package com.example.apiusermonitoring.adapters.driving.http.mapper;

import com.example.apiusermonitoring.adapters.driving.http.dto.response.CountryResponseDto;
import com.example.apiusermonitoring.domain.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICountryResponseMapper {

    CountryResponseDto toResponse(Country country);

    List<CountryResponseDto> toResponseList(List<Country> countryList);

}
