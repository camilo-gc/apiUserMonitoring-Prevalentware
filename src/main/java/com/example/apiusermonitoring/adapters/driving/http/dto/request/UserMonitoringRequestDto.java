package com.example.apiusermonitoring.adapters.driving.http.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.example.apiusermonitoring.configuration.Constants.REGEX_DATE_FORMAT;
import static com.example.apiusermonitoring.configuration.Constants.NO_EMPTY_MESSAGE;
import static com.example.apiusermonitoring.configuration.Constants.INVALID_DATE_FORMAT_MESSAGE;


@NoArgsConstructor
@Getter
public class UserMonitoringRequestDto {

    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Email
    private String email;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Pattern(regexp = REGEX_DATE_FORMAT, message = INVALID_DATE_FORMAT_MESSAGE)
    @JsonProperty(value = "start_date")
    private String startDate;
    @NotBlank(message = NO_EMPTY_MESSAGE)
    @Pattern(regexp = REGEX_DATE_FORMAT, message = INVALID_DATE_FORMAT_MESSAGE)
    @JsonProperty(value = "end_date")
    private String endDate;

}
