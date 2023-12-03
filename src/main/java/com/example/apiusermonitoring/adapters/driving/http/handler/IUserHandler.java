package com.example.apiusermonitoring.adapters.driving.http.handler;

import com.example.apiusermonitoring.adapters.driving.http.dto.UserResponseDto;

import java.util.List;

public interface IUserHandler {

    List<UserResponseDto> getUsers(int page, int size);

}
