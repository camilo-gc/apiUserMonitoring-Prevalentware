package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.UserNotFoundException;
import com.example.apiusermonitoring.databuilder.UserDataBuilder;
import com.example.apiusermonitoring.databuilder.UserMonitoringDataBuilder;
import com.example.apiusermonitoring.domain.api.IUserServicePort;
import com.example.apiusermonitoring.domain.exception.InvalidDateRangeException;
import com.example.apiusermonitoring.domain.model.User;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import com.example.apiusermonitoring.domain.spi.IUserMonitoringPersistencePort;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    private IUserPersistencePort userPersistencePort;
    private IUserMonitoringPersistencePort userMonitoringPersistencePort;
    private IUserServicePort userServicePort;

    @BeforeEach
    void setUp() {
        userPersistencePort = mock(IUserPersistencePort.class);
        userMonitoringPersistencePort = mock(IUserMonitoringPersistencePort.class);
        userServicePort = new UserUseCase(userPersistencePort, userMonitoringPersistencePort);
    }

    @Test
    void testGetAllUsers() {

        List<User> userList = UserDataBuilder.buildList(5);

        when(userPersistencePort.findAllUsers(any(Pageable.class))).thenReturn(userList);
        assertEquals(userList, userServicePort.getAllUsers(Pageable.unpaged()));
        verify(userPersistencePort, times(1)).findAllUsers(any(Pageable.class));

    }

    @Test
    void testGetAllUsers_NotFoundException() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name"));

        doThrow(NoDataFoundException.class).when(userPersistencePort).findAllUsers(pageable);
        assertThrows(NoDataFoundException.class, () -> userServicePort.getAllUsers(pageable));

    }

    @Test
    void testGetUserByEmail() {

        User expectedUserUser = UserDataBuilder.build("1");
        String email = expectedUserUser.getEmail();

        when(userPersistencePort.findUserByEmail(email)).thenReturn(expectedUserUser);
        User actualUser = userServicePort.getUserByEmail(email);
        assertNotNull(actualUser);
        assertSame(expectedUserUser, actualUser);
        verify(userPersistencePort, times(1)).findUserByEmail(email);

    }

    @Test
    void testGetUserByEmail_UserNotFoundException() {

        String email = "prueba@prueba.com";

        doThrow(UserNotFoundException.class).when(userPersistencePort).findUserByEmail(email);
        assertThrows(UserNotFoundException.class, () -> userServicePort.getUserByEmail(email));

    }

    @Test
    void testGetTop3UsersWithMaxRecordsAndTimeRange() {

        List<User> userList = UserDataBuilder.buildList(3);

        when(userPersistencePort.findTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now(), LocalDate.now())).thenReturn(userList);
        assertEquals(userList, userServicePort.getTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now().toString(), LocalDate.now().toString()));
        verify(userPersistencePort, times(1)).findTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now(), LocalDate.now());

    }

    @Test
    void testGetTop3UsersWithMaxRecordsAndTimeRange_NotFountException() {

        doThrow(NoDataFoundException.class).when(userPersistencePort).findTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now(), LocalDate.now());
        assertThrows(NoDataFoundException.class, () -> userServicePort.getTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now().toString(), LocalDate.now().toString()));

    }

    @Test
    void testGetTop3UsersWithMaxRecordsAndTimeRange_InvalidDateRangeException() {

        doThrow(InvalidDateRangeException.class).when(userPersistencePort).findTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now(), LocalDate.now());
        assertThrows(InvalidDateRangeException.class, () -> userServicePort.getTop3UsersWithMaxRecordsAndTimeRange(LocalDate.now().toString(), LocalDate.now().toString()));

    }

    @Test
    void testGetUsersByDescriptionAndCountryAndTimeRange() {
        List<UserMonitoring> userMonitoringList = UserMonitoringDataBuilder.buildList(5);
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name"));

        when(userMonitoringPersistencePort.findUserByDescriptionAndCountryAndTimeRange(anyString(), anyString(), eq(LocalDate.now()), eq(LocalDate.now()), eq(pageable)))
                .thenReturn(userMonitoringList);

        List<User> userList = userServicePort
                .getUsersByDescriptionAndCountryAndTimeRange(
                        "description",
                        "countryId",
                        LocalDate.now().toString(),
                        LocalDate.now().toString(),
                        pageable
                );

        assertNotNull(userList);
        verify(userMonitoringPersistencePort, times(1))
                .findUserByDescriptionAndCountryAndTimeRange(anyString(), anyString(), eq(LocalDate.now()), eq(LocalDate.now()), eq(pageable));

    }

    @Test
    void testGetUsersByDescriptionAndCountryAndTimeRange_NotDataFountException() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name"));
        when(userMonitoringPersistencePort.findUserByDescriptionAndCountryAndTimeRange(anyString(), anyString(), eq(LocalDate.now()), eq(LocalDate.now()), eq(pageable)))
                .thenThrow(NoDataFoundException.class);

        assertThrows(
                NoDataFoundException.class,
                () -> userServicePort.getUsersByDescriptionAndCountryAndTimeRange(
                        "description",
                        "countryId",
                        LocalDate.now().toString(),
                        LocalDate.now().toString(),
                        pageable
                )
        );
        verify(userMonitoringPersistencePort, times(1))
                .findUserByDescriptionAndCountryAndTimeRange(anyString(), anyString(), eq(LocalDate.now()), eq(LocalDate.now()), eq(pageable));

    }

    @Test
    void testGetUsersByDescriptionAndCountryAndTimeRange_InvalidDateRangeException() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name"));

        assertThrows(
                InvalidDateRangeException.class,
                () -> userServicePort.getUsersByDescriptionAndCountryAndTimeRange(
                        "description",
                        "countryId",
                        "2023-04-16",
                        "2023-02-16",
                        pageable
                )
        );

        verify(userMonitoringPersistencePort, never())
                .findUserByDescriptionAndCountryAndTimeRange(anyString(), anyString(), eq(LocalDate.now()), eq(LocalDate.now()), eq(pageable));

    }

}