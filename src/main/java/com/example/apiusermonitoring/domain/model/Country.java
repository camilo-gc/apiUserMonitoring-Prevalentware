package com.example.apiusermonitoring.domain.model;

import java.util.Date;
import java.util.Set;

public class Country {

    private String id;
    private String name;
    private Date createAt;
    private Date updateAt;
    private Set<User> users;

    public Country(String id, String name, Date createAt, Date updateAt, Set<User> users) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
