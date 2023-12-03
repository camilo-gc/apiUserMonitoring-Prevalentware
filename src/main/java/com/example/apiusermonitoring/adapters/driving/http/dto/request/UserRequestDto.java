package com.example.apiusermonitoring.adapters.driving.http.dto.request;

import com.example.apiusermonitoring.configuration.Constants;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {

    @NotBlank(message = Constants.NO_EMPTY_MESSAGE)
    @Email
    private String email;

}
