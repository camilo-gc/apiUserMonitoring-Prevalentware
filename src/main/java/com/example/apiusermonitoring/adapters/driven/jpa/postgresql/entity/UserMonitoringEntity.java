package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "UserMonitoring")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserMonitoringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer usage;
    private String description;
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
}
