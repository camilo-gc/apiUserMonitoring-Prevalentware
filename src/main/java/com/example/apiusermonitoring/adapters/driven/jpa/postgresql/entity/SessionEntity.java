package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "\"Session\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @Column(name = "\"sessionToken\"")
    private String sessionToken;
    @Column(name = "\"createdAt\"")
    private Date createdAt;
    @Column(name = "\"expiresAt\"")
    private Date expiresAt;
    @ManyToOne
    @JoinColumn(name = "\"userId\"")
    private UserEntity userEntity;
}
