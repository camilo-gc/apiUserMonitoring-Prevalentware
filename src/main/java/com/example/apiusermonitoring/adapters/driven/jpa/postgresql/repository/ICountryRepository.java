package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<CountryEntity, String> {

}
