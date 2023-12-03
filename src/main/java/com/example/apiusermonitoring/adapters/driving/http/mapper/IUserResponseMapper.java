package com.example.apiusermonitoring.adapters.driving.http.mapper;

import com.example.apiusermonitoring.adapters.driving.http.dto.UserResponseDto;
import com.example.apiusermonitoring.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    UserResponseDto toResponse(User user);

    List<UserResponseDto> toResponseList(List<User> userList);

}
