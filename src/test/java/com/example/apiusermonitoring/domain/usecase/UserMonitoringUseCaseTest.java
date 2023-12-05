package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.databuilder.UserMonitoringDataBuilder;
import com.example.apiusermonitoring.domain.api.IUserMonitoringServicePort;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import com.example.apiusermonitoring.domain.spi.IUserMonitoringPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserMonitoringUseCaseTest {

    private IUserMonitoringPersistencePort userMonitoringPersistencePort;
    private IUserMonitoringServicePort userMonitoringServicePort;

    @BeforeEach
    void setUp() {
        userMonitoringPersistencePort = mock(IUserMonitoringPersistencePort.class);
        userMonitoringServicePort = new UserMonitoringUseCase(userMonitoringPersistencePort);
    }

    @Test
    void testGetUserMonitoringByEmailAndTimeRange() {
        UserMonitoring userMonitoring = UserMonitoringDataBuilder.build("1");
        String userEmail = userMonitoring.getUser().getEmail();
        LocalDate startDate = userMonitoring.getCreatedAt();
        LocalDate endDate = userMonitoring.getCreatedAt();
        Pageable pageable = PageRequest.of( 0, 10, Sort.by(Sort.Direction.ASC, "name") );

        List<UserMonitoring> expectedUserMonitoringList = UserMonitoringDataBuilder.buildList(5);
        when(userMonitoringPersistencePort.findUserMonitoringByEmailAndTimeRange(userEmail, startDate, endDate, pageable))
                .thenReturn(expectedUserMonitoringList);

        List<UserMonitoring> result = userMonitoringServicePort
                .getUserMonitoringByEmailAndTimeRange(userEmail, startDate.toString(), endDate.toString(), pageable);
        assertEquals(expectedUserMonitoringList, result);
    }

    @Test
    void testGetUserMonitoringByEmailAndTimeRangeNotFoundException() {
        UserMonitoring userMonitoring = UserMonitoringDataBuilder.build("1");
        String userEmail = userMonitoring.getUser().getEmail();
        LocalDate startDate = userMonitoring.getCreatedAt();
        LocalDate endDate = userMonitoring.getCreatedAt();
        Pageable pageable = PageRequest.of( 0, 10, Sort.by(Sort.Direction.ASC, "name") );

        doThrow(NoDataFoundException.class).when(userMonitoringPersistencePort)
                .findUserMonitoringByEmailAndTimeRange(userEmail, startDate, endDate, pageable);
        assertThrows(NoDataFoundException.class, () -> userMonitoringServicePort
                .getUserMonitoringByEmailAndTimeRange(userEmail, startDate.toString(), endDate.toString(), pageable));

    }

}