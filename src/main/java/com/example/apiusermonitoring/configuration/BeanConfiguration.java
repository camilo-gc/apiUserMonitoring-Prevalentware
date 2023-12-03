package com.example.apiusermonitoring.configuration;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter.CountryAdapter;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter.UserAdapter;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.ICountryEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IUserEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.ICountryRepository;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IUserRepository;
import com.example.apiusermonitoring.domain.api.ICountryServicePort;
import com.example.apiusermonitoring.domain.api.IUserServicePort;
import com.example.apiusermonitoring.domain.spi.ICountryPersistencePort;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import com.example.apiusermonitoring.domain.usecase.CountryUseCase;
import com.example.apiusermonitoring.domain.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final ICountryRepository countryRepository;
    private final ICountryEntityMapper countryEntityMapper;

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public ICountryServicePort countryServicePort() {
        return new CountryUseCase(countryPersistencePort());
    }

    @Bean
    public ICountryPersistencePort countryPersistencePort() {
        return new CountryAdapter(countryRepository, countryEntityMapper);
    }

}
