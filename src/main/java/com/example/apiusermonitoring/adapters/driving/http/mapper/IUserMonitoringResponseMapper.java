package com.example.apiusermonitoring.adapters.driving.http.mapper;

import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserMonitoringResponseDto;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserMonitoringResponseMapper {

    @Mapping(target = "userId", source = "user.id")
    UserMonitoringResponseDto toResponse(UserMonitoring userMonitoring);

    List<UserMonitoringResponseDto> toResponseList(List<UserMonitoring> userMonitoringList);

}
