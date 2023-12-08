package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.adapter;

import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.exception.RoleNotFoundException;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.mapper.IRoleEntityMapper;
import com.example.apiusermonitoring.adapters.driven.jpa.postgresql.repository.IRoleRepository;
import com.example.apiusermonitoring.domain.model.Role;
import com.example.apiusermonitoring.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleAdapter implements IRolePersistencePort {

    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public Role findRoleById(String roleId) {

        return roleEntityMapper.toRole(
                roleRepository.findById(roleId).orElseThrow(RoleNotFoundException::new)
        );
    }

}
