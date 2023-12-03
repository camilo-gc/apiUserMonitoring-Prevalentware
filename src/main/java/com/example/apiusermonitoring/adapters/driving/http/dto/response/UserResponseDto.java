package com.example.apiusermonitoring.adapters.driving.http.dto.response;

import com.example.apiusermonitoring.domain.model.Country;
import com.example.apiusermonitoring.domain.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@Getter
public class UserResponseDto {

    private String id;
    private String email;
    private String name;
    private String image;
    private String position;
    @JsonProperty(value = "email_verified")
    private Date emailVerified;
    @JsonProperty(value = "terms_and_conditions_accepted")
    private Date termsAndConditionsAccepted;
    @JsonProperty(value = "created_at")
    private Date createdAt;
    @JsonProperty(value = "updated_at")
    private Date updatedAt;
    private Role role;
    private Set<Country> countries;

}
