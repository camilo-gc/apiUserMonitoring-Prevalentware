package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.CountryEntity;
import com.example.apiusermonitoring.domain.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICountryEntityMapper {

    @Mapping(target = "users", source = "usersEntity")
    Country toCountry(CountryEntity countryEntity);

    List<Country> toCountryList(List<CountryEntity> countryEntityList);

}
