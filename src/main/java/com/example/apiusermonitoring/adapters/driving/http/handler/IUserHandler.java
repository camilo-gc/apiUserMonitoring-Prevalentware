package com.example.apiusermonitoring.adapters.driving.http.handler;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.TimeRangeRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserMonitoringFieldsRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserResponseDto;

import java.util.List;

public interface IUserHandler {

    List<UserResponseDto> getUsers(int page, int size);

    UserResponseDto getUserByEmail(String email);

    List<UserResponseDto> getTop3UsersOfRecords(TimeRangeRequestDto timeRangeRequestDto, int page, int size);

    List<UserResponseDto> getUsersByDescriptionAndCountryAndTimeRange(UserMonitoringFieldsRequestDto userMonitoringFieldsRequestDto, int page, int size);

}
