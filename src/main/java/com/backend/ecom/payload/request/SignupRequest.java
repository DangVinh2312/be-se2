package com.backend.ecom.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {
    @Size(min = 10, max = 100)
    private String fullName;

    @Size(min = 2, max = 100)
    private String username;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @Size(min = 6, max = 150)
    private String password;

    @NotBlank
    private String address;
}
