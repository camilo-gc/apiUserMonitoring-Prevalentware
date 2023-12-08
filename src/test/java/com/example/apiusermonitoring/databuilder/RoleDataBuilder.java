package com.example.apiusermonitoring.databuilder;

import com.example.apiusermonitoring.domain.model.Role;

import java.time.LocalDate;

public class RoleDataBuilder {

    public static Role build(String name){
        return new Role("1", name, LocalDate.now());
    }

}
