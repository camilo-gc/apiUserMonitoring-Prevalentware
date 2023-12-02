package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String email;
    private String name;
    private String image;
    private String position;
    private Date emailVerified;
    private Date termsAndConditionsAccepted;
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private RoleEntity roleEntity;
    @ManyToMany
    @JoinTable(
            name = "_CountryToUser",
            joinColumns = @JoinColumn(name = "A"), // Columna que referencia a User
            inverseJoinColumns = @JoinColumn(name = "B") // Columna que referencia a Country
    )
    private Set<CountryEntity> countriesEntity;// = new HashSet<>()
}
