package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

}
