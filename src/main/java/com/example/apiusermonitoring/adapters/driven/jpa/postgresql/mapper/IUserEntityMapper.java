package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.CountryEntity;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserEntity;
import com.example.apiusermonitoring.domain.model.Country;
import com.example.apiusermonitoring.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    @Mapping(target = "roleEntity.id", source = "role.id")
    UserEntity toEntity(User user);

    @Mapping(target = "role.id", source = "roleEntity.id")
    @Mapping(target = "countries", source = "countriesEntity")
    User toUser(UserEntity userEntity);

    List<User> toUserList(List<UserEntity> userEntityList);

}
