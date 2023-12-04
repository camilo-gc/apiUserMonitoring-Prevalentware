package com.example.apiusermonitoring.domain.api;

import com.example.apiusermonitoring.domain.model.UserMonitoring;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IUserMonitoringServicePort {

    List<UserMonitoring> getUserMonitoringByEmailAndTimeRange(String userEmail, String startDate, String endDate, Pageable pageable);

}
