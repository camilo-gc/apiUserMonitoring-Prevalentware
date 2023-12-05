package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    @Query("SELECT us, COUNT(us.id) as totalRecords " +
            "FROM UserMonitoringEntity um " +
            "INNER JOIN UserEntity us ON us.id = um.userEntity.id " +
            "WHERE um.createdAt BETWEEN :startDate AND :endDate " +
            "GROUP BY us.id " +
            "ORDER BY totalRecords DESC " +
            "LIMIT 3"
    )
    List<UserEntity> findTop3UsersMaxRecordsAndCreatedAtBetween(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}
