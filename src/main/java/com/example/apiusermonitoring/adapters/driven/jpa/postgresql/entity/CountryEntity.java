package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "\"Country\"", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String name;
    @Column(name = "\"createdAt\"")
    private Date createdAt;
    @Column(name = "\"updatedAt\"")
    private Date updatedAt;
    @ManyToMany
    @JoinTable(
            name = "\"_CountryToUser\"",
            joinColumns = @JoinColumn(name = "\"A\""),
            inverseJoinColumns = @JoinColumn(name = "\"B\"")
    )
    private Set<UserEntity> usersEntity;

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", usersEntity=" + usersEntity +
                '}';
    }

}
