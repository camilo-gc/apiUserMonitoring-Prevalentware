package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserEntity;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IUserEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IUserRepository;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.UserNotFoundException;
import com.example.apiusermonitoring.domain.model.User;
import com.example.apiusermonitoring.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.*;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public List<User> findAllUsers(Pageable pageable) {
        List<UserEntity> userEntityList = userRepository.findAll(pageable).getContent();
        if (userEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public User findUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null){
            throw new UserNotFoundException();
        }
        return userEntityMapper.toUser(userEntity);
    }

}
