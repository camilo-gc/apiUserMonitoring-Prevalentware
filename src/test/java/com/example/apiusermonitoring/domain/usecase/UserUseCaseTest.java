package com.example.apiusermonitoring.domain.usecase;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.UserNotFoundException;
import com.example.apiusermonitoring.domain.api.IUserServicePort;
import com.example.apiusermonitoring.domain.model.User;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    private IUserPersistencePort userPersistencePort;
    private IUserServicePort userServicePort;

    @BeforeEach
    void setUp() {
        userPersistencePort = mock(IUserPersistencePort.class);
        userServicePort = new UserUseCase(userPersistencePort);
    }

    @Test
    void testGetAllUsers() {

        List<User> userList = UserData.buildList(5);

        when(userPersistencePort.findAllUsers(any(Pageable.class))).thenReturn(userList);
        assertEquals(userList, userServicePort.getAllUsers(Pageable.unpaged()));
        verify(userPersistencePort, times(1)).findAllUsers(any(Pageable.class));

    }

    @Test
    void testGetAllUsersWithNoUsers() {

        Pageable pageable = PageRequest.of( 0, 10, Sort.by(Sort.Direction.ASC, "name") );

        doThrow(NoDataFoundException.class).when(userPersistencePort).findAllUsers(pageable);
        assertThrows(NoDataFoundException.class, () -> userServicePort.getAllUsers(pageable));

    }

    @Test
    void testGetUserByEmail() {

        User expectedUserUser = UserData.build("1");
        String email = expectedUserUser.getEmail();
        
        when(userPersistencePort.findUserByEmail(email)).thenReturn(expectedUserUser);
        User actualUser  = userServicePort.getUserByEmail(email);
        assertNotNull(actualUser );
        assertSame(expectedUserUser, actualUser );
        verify(userPersistencePort, times(1)).findUserByEmail(email);

    }

    @Test
    void testGetUserByEmail_NonExistingEmail() {

        String email = "prueba@prueba.com";

        doThrow(UserNotFoundException.class).when(userPersistencePort).findUserByEmail(email);
        assertThrows(UserNotFoundException.class, () -> userServicePort.getUserByEmail(email));

    }

}