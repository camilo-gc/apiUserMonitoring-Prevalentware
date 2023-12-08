package com.example.apiusermonitoring.domain.spi;

import com.example.apiusermonitoring.domain.model.Role;

public interface IRolePersistencePort {

    Role findRoleById(String roleId);

}
