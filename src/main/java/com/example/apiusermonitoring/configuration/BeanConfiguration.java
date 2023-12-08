package com.example.apiusermonitoring.configuration;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter.CountryAdapter;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter.RoleAdapter;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter.UserAdapter;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter.UserMonitoringAdapter;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.ICountryEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IRoleEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IUserEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IUserMonitoringEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.ICountryRepository;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IRoleRepository;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IUserMonitoringRepository;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IUserRepository;
import com.example.apiusermonitoring.domain.api.ICountryServicePort;
import com.example.apiusermonitoring.domain.api.IUserMonitoringServicePort;
import com.example.apiusermonitoring.domain.api.IUserServicePort;
import com.example.apiusermonitoring.domain.spi.ICountryPersistencePort;
import com.example.apiusermonitoring.domain.spi.IRolePersistencePort;
import com.example.apiusermonitoring.domain.spi.IUserMonitoringPersistencePort;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import com.example.apiusermonitoring.domain.usecase.CountryUseCase;
import com.example.apiusermonitoring.domain.usecase.UserMonitoringUseCase;
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
    private final IUserMonitoringRepository userMonitoringRepository;
    private final IUserMonitoringEntityMapper userMonitoringEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), userMonitoringPersistencePort(), rolePersistencePort());
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

    @Bean
    public IUserMonitoringServicePort userMonitoringServicePort() {
        return new UserMonitoringUseCase(userMonitoringPersistencePort());
    }

    @Bean
    public IUserMonitoringPersistencePort userMonitoringPersistencePort() {
        return new UserMonitoringAdapter(userMonitoringRepository, userMonitoringEntityMapper);
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleAdapter(roleRepository, roleEntityMapper);
    }

}
