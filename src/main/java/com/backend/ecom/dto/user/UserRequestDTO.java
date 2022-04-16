package com.backend.ecom.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    @Size(max = 100)
    private String image;

    @Size(min = 10, max = 50)
    private String fullName;

    @Size(min = 2, max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String role;

    @Size(min = 6, max = 150)
    private String password;
}
