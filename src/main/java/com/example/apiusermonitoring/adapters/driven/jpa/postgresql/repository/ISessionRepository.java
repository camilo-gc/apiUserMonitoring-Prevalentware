package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessionRepository extends JpaRepository<SessionEntity, String> {

    SessionEntity findBySessionToken(String token);

}
