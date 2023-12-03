package com.example.apiusermonitoring.adapters.driving.http.handler;

import com.example.apiusermonitoring.adapters.driving.http.dto.response.UserResponseDto;

import java.util.List;

public interface IUserHandler {

    List<UserResponseDto> getUsers(int page, int size);

    UserResponseDto getUserByEmail(String email);

}
