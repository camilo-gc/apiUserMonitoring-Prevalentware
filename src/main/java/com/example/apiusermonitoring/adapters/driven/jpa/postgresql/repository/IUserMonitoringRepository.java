package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserMonitoringEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IUserMonitoringRepository extends JpaRepository<UserMonitoringEntity, String> {

    @Query("SELECT userMonitoring " +
           "FROM UserMonitoringEntity userMonitoring " +
           "INNER JOIN UserEntity user ON user.id = userMonitoring.userEntity.id " +
           "WHERE userMonitoring.userEntity.email = :userEmail " +
           "AND userMonitoring.createdAt BETWEEN :startDate AND :endDate"
    )
    List<UserMonitoringEntity> findByUserEmailAndCreatedAtBetween(
            @Param("userEmail") String userEmail,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );

    List<UserMonitoringEntity> findByDescriptionAndUserEntity_CountriesEntity_IdAndCreatedAtBetween(
            String description, String countryId, LocalDate startDate, LocalDate endDate, Pageable pageable
    );

}
