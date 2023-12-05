package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserMonitoringEntity;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserMonitoringEntityMapper {

    @Mapping(target = "user", source = "userEntity")
    UserMonitoring toUserMonitoring(UserMonitoringEntity userMonitoringEntity);

    List<UserMonitoring> toUserMonitoringList(List<UserMonitoringEntity> userMonitoringEntityList);

}
