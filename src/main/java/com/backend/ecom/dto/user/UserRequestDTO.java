package com.backend.ecom.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {
    @Size(min = 10, max = 50)
    @NotBlank
    private String fullName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 150)
    private String password;

    @Size(max = 200)
    private String address;

    @Size(max = 100)
    private String image;
}
