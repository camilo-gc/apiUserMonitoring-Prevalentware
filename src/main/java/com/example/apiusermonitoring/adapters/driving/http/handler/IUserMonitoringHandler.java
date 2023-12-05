package com.example.apiusermonitoring.adapters.driving.http.handler;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserMonitoringRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserMonitoringResponseDto;

import java.util.List;

public interface IUserMonitoringHandler {

    List<UserMonitoringResponseDto> getUserMonitoring(UserMonitoringRequestDto userMonitoringRequestDto, int page, int size);

}
