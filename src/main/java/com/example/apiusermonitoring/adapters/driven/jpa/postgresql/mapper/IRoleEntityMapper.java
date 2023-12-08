package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.RoleEntity;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserEntity;
import com.example.apiusermonitoring.domain.model.Role;
import com.example.apiusermonitoring.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {

    Role toRole(RoleEntity roleEntity);

}
