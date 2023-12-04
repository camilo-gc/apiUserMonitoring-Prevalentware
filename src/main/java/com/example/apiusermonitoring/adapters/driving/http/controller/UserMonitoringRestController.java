package com.example.apiusermonitoring.adapters.driving.http.controller;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserMonitoringRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserMonitoringResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.IUserMonitoringHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-test")
@RequiredArgsConstructor
public class UserMonitoringRestController {

    private final IUserMonitoringHandler userMonitoringHandler;

    @GetMapping("/user-monitoring")
    public ResponseEntity<List<UserMonitoringResponseDto>> getUserMonitoring(@Valid @RequestBody UserMonitoringRequestDto userMonitoringRequestDto,
                                                                       @RequestParam(defaultValue = "1") Integer page,
                                                                       @RequestParam(defaultValue = "10") Integer size)  {
        return ResponseEntity.ok(userMonitoringHandler.getUserMonitoring(userMonitoringRequestDto, page, size));
    }

}
