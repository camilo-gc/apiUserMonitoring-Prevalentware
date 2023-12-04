package com.example.apiusermonitoring.domain.model;

import java.time.LocalDate;

public class UserMonitoring {

    private String id;
    private Integer usage;
    private String description;
    private LocalDate createdAt;
    private User user;

    public UserMonitoring(String id, Integer usage, String description, LocalDate createdAt, User user) {
        this.id = id;
        this.usage = usage;
        this.description = description;
        this.createdAt = createdAt;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
