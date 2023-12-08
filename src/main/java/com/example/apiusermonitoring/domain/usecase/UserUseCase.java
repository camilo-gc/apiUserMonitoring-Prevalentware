package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.domain.api.IUserServicePort;
import com.example.apiusermonitoring.domain.model.User;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import com.example.apiusermonitoring.domain.spi.IRolePersistencePort;
import com.example.apiusermonitoring.domain.spi.IUserMonitoringPersistencePort;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import com.example.apiusermonitoring.domain.utils.DateUtils;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.example.apiusermonitoring.configuration.Constants.USER_ROLE;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IUserMonitoringPersistencePort userMonitoringPersistencePort;
    private final IRolePersistencePort rolePersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IUserMonitoringPersistencePort userMonitoringPersistencePort,
                       IRolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.userMonitoringPersistencePort = userMonitoringPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    public List<User> getAllUsers(String email, String roleId, Pageable pageable) {
        if (rolePersistencePort.findRoleById(roleId).getName().equals(USER_ROLE)) {
            return List.of(getUserByEmail(email));
        }
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

    public List<User> getUsersByDescriptionAndCountryAndTimeRange(String description, String countryId, String startDate, String endDate, Pageable pageable) {
        DateUtils.validateDateRange(startDate, endDate);
        List<UserMonitoring> userMonitoringList = userMonitoringPersistencePort.findUserByDescriptionAndCountryAndTimeRange(
                description,
                countryId,
                DateUtils.convertToDate(startDate),
                DateUtils.convertToDate(endDate),
                pageable
        );

        return userMonitoringList.stream()
                .map(UserMonitoring::getUser)
                .distinct()
                .toList();
    }

}
