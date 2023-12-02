package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Session")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String sessionToken;
    private Date createdAt;
    private Date expiresAt;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
}
