package com.example.apiusermonitoring.adapters.driven.jpa.postgresql.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PrincipalUser implements UserDetails {

    private String id;
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String id, String userName,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id=id;
        this.userName = userName;
        this.authorities = authorities;
    }

    public static PrincipalUser build(UserEntity user, List<RoleEntity> roles) {
        List<GrantedAuthority> authorities = roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
        return new PrincipalUser(user.getId(), user.getEmail(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "PrincipalUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", authorities=" + authorities +
                '}';
    }

}
