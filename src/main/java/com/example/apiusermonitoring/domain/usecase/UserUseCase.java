package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.domain.api.IUserServicePort;
import com.example.apiusermonitoring.domain.model.User;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import com.example.apiusermonitoring.domain.utils.DateUtils;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    public List<User> getAllUsers(Pageable pageable){
        return userPersistencePort.findAllUsers(pageable);
    }

    public User getUserByEmail(String email) {
        return userPersistencePort.findUserByEmail(email);
    }

    public List<User> getTop3UsersWithMaxRecordsAndTimeRange(String startDate, String endDate) {

        DateUtils.validateDateRange(startDate, endDate);
        return userPersistencePort.findTop3UsersWithMaxRecordsAndTimeRange(
                DateUtils.convertToDate(startDate),
                DateUtils.convertToDate(endDate)
        );
    }

}
