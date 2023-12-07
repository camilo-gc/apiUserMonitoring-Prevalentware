package com.example.apiusermonitoring.configuration.security;

import com.example.apiusermonitoring.configuration.security.jwt.JwtTokenFilter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.apiusermonitoring.configuration.Constants.*;

@Configuration
@EnableWebSecurity
@CommonsLog
public class MainSecurity {

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests -> requests
                        .requestMatchers("/api-test/users/max-monitoring-records", "/api-test/users/description-and-country").hasAuthority(ADMIN_ROLE)
                        .requestMatchers("/api-test/countries", "/api-test/users", "/api-test/users/search").hasAnyAuthority(ADMIN_ROLE, MANAGER_ROLE)
                        .requestMatchers("/api-test/users", "/api-test/users/search", "/api-test/user-monitoring").hasAnyAuthority(USER_ROLE, ADMIN_ROLE)
                        .anyRequest().authenticated()
                )
                .formLogin().disable();
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
