package com.example.apiusermonitoring.domain.spi;

import com.example.apiusermonitoring.domain.model.User;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IUserPersistencePort {

    List<User> findAllUsers(Pageable pageable);

    User findUserByEmail(String email);

    List<User> findTop3UsersWithMaxRecordsAndTimeRange(LocalDate startDate, LocalDate endDate);

}
