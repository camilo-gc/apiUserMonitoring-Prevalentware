package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "\"UserMonitoring\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserMonitoringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private Integer usage;
    private String description;
    @Column(name = "\"createdAt\"")
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn(name = "\"userId\"")
    private UserEntity userEntity;
}
