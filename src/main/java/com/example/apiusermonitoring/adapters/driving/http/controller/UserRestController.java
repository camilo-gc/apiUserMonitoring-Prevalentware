package com.example.apiusermonitoring.adapters.driving.http.controller;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.TimeRangeRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserMonitoringFieldsRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-test/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @GetMapping("")
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.ok(userHandler.getUsers(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponseDto> getUserByEmail(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userHandler.getUserByEmail(userRequestDto.getEmail()));
    }

    @GetMapping("/max-monitoring-records")
    public ResponseEntity<List<UserResponseDto>> getTop3UsersOfRecords(@Valid @RequestBody TimeRangeRequestDto timeRangeRequestDto,
                                                                       @RequestParam(defaultValue = "1") Integer page,
                                                                       @RequestParam(defaultValue = "10") Integer size)  {
        return ResponseEntity.ok(userHandler.getTop3UsersOfRecords(timeRangeRequestDto, page, size));
    }

    @GetMapping("/description-and-country")
    public ResponseEntity<List<UserResponseDto>> getUsersByDescriptionAndCountryAndTimeRange(@Valid @RequestBody UserMonitoringFieldsRequestDto userMonitoringFieldsRequestDto,
                                                                                                       @RequestParam(defaultValue = "1") Integer page,
                                                                                                       @RequestParam(defaultValue = "10") Integer size)  {
        return ResponseEntity.ok(userHandler.getUsersByDescriptionAndCountryAndTimeRange(userMonitoringFieldsRequestDto, page, size));
    }

}
