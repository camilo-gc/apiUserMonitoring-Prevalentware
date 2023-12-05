package com.example.apiusermonitoring.adapters.driving.http.handler.impl;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.TimeRangeRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.IUserHandler;
import com.example.apiusermonitoring.adapters.driving.http.mapper.IUserResponseMapper;
import com.example.apiusermonitoring.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public List<UserResponseDto> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of( page-1, size, Sort.by(Sort.Direction.ASC, "name"));
        return userResponseMapper.toResponseList( userServicePort.getAllUsers(pageable) );
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        return userResponseMapper.toResponse(userServicePort.getUserByEmail(email));
    }

    @Override
    public List<UserResponseDto> getTop3UsersOfRecords(TimeRangeRequestDto timeRangeRequestDto, int page, int size) {

        return userResponseMapper.toResponseList(
                userServicePort.getTop3UsersWithMaxRecordsAndTimeRange(
                        timeRangeRequestDto.getStartDate(),
                        timeRangeRequestDto.getEndDate()
                )
        );

    }

}
