package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(mappedBy = "countriesEntity")
    private Set<UserEntity> usersEntity;
}
