package com.example.apiusermonitoring.adapters.driving.http.controller;

import com.example.apiusermonitoring.adapters.driving.http.dto.request.UserRequestDto;
import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-test")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.ok(userHandler.getUsers(page, size));
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> getUserByEmail(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userHandler.getUserByEmail(userRequestDto.getEmail()));
    }

}
