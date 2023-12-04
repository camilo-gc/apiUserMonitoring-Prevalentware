package com.example.apiusermonitoring.adapters.driving.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class UserMonitoringResponseDto {

    private String id;
    private Integer usage;
    private String description;
    @JsonProperty(value = "created_at")
    private Date createdAt;
    @JsonProperty(value = "user_id")
    private String userId;

}
