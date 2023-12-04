package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserMonitoringEntity;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.NoDataFoundException;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IUserMonitoringEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IUserMonitoringRepository;
import com.example.apiusermonitoring.domain.model.UserMonitoring;
import com.example.apiusermonitoring.domain.spi.IUserMonitoringPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class UserMonitoringAdapter implements IUserMonitoringPersistencePort {

    private final IUserMonitoringRepository userMonitoringRepository;
    private final IUserMonitoringEntityMapper userMonitoringEntityMapper;

    @Override
    public List<UserMonitoring> findUserMonitoringByEmailAndTimeRange(String userEmail, LocalDate startDate, LocalDate endDate, Pageable pageable) {

        List<UserMonitoringEntity> userMonitoringEntityList = userMonitoringRepository.findByUserEmailAndCreatedAtBetween(userEmail, startDate, endDate, pageable);
        if (userMonitoringEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userMonitoringEntityMapper.toUserMonitoringList(userMonitoringEntityList);
    }

}
