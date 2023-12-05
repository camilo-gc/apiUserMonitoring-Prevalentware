package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "\"User\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String email;
    private String name;
    private String image;
    private String position;
    @Column(name = "\"emailVerified\"")
    private Date emailVerified;
    @Column(name = "\"termsAndConditionsAccepted\"")
    private Date termsAndConditionsAccepted;
    @Column(name = "\"createdAt\"")
    private Date createdAt;
    @Column(name = "\"updatedAt\"")
    private Date updatedAt;
    @ManyToOne
    @JoinColumn(name = "\"roleId\"")
    private RoleEntity roleEntity;
    @ManyToMany(mappedBy = "usersEntity")
    private Set<CountryEntity> countriesEntity;

}
