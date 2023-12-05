package com.example.apiusermonitoring.adapters.driving.http.handler.impl;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserMonitoringRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserMonitoringResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.IUserMonitoringHandler;
import com.example.apiusermonitoring.adapters.driving.http.mapper.IUserMonitoringResponseMapper;
import com.example.apiusermonitoring.domain.api.IUserMonitoringServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMonitoringHandlerImpl implements IUserMonitoringHandler {

    private final IUserMonitoringServicePort userMonitoringServicePort;
    private final IUserMonitoringResponseMapper userMonitoringResponseMapper;

    @Override
    public List<UserMonitoringResponseDto> getUserMonitoring(UserMonitoringRequestDto userMonitoringRequestDto, int page, int size) {
        Pageable pageable = PageRequest.of( page-1, size, Sort.by(Sort.Direction.ASC, "description"));

        return userMonitoringResponseMapper.toResponseList(
                userMonitoringServicePort.getUserMonitoringByEmailAndTimeRange(
                        userMonitoringRequestDto.getEmail(),
                        userMonitoringRequestDto.getStartDate(),
                        userMonitoringRequestDto.getEndDate(),
                        pageable
                )
        );
    }

}
