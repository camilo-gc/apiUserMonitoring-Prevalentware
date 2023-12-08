package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, String> {

}
