package com.example.apiusermonitoring.domain.spi;

import com.example.apiusermonitoring.domain.model.UserMonitoring;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IUserMonitoringPersistencePort {

    List<UserMonitoring> findUserMonitoringByEmailAndTimeRange(String userEmail, LocalDate startDate, LocalDate endDate, Pageable pageable);

}
