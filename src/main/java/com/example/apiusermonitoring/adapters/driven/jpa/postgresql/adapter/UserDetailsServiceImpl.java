package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.PrincipalUser;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.SessionEntity;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.ISessionRepository;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.InvalidTokenException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommonsLog
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ISessionRepository sessionRepository;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {

        SessionEntity session = sessionRepository.findBySessionToken(token);
        if (session == null) {
            throw new InvalidTokenException();
        }

        return PrincipalUser.build(session.getUserEntity(), List.of(session.getUserEntity().getRoleEntity()));
    }

}
