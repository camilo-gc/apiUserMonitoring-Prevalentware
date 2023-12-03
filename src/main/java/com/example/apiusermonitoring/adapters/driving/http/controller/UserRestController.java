package com.example.apiusermonitoring.adapters.driving.http.controller;

import com.example.apiusermonitoring.adapters.driving.http.dto.UserResponseDto;
import com.example.apiusermonitoring.adapters.driving.http.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-test")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUsers(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.ok(userHandler.getUsers(page, size));
    }

}
