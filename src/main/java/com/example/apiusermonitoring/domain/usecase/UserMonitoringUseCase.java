package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.domain.api.IUserMonitoringServicePort;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import com.example.apiusermonitoring.domain.spi.IUserMonitoringPersistencePort;
import com.example.apiusermonitoring.domain.utils.DateUtils;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserMonitoringUseCase implements IUserMonitoringServicePort {

    private final IUserMonitoringPersistencePort userMonitoringPersistencePort;

    public UserMonitoringUseCase(IUserMonitoringPersistencePort userMonitoringPersistencePort) {
        this.userMonitoringPersistencePort = userMonitoringPersistencePort;
    }

    @Override
    public List<UserMonitoring> getUserMonitoringByEmailAndTimeRange(String userEmail, String startDate, String endDate, Pageable pageable) {
        return userMonitoringPersistencePort.findUserMonitoringByEmailAndTimeRange(
                userEmail,
                DateUtils.convertToDate(startDate),
                DateUtils.convertToDate(endDate),
                pageable
        );
    }

}
