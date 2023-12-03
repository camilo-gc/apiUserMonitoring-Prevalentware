package com.example.apiusermonitoring.domain.api;

import com.example.apiusermonitoring.domain.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserServicePort {

    List<User> getAllUsers(Pageable pageable);
}
