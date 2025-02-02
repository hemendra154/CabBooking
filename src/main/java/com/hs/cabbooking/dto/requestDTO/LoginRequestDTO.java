package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "email is required")
    @Email(message = "Invalid email Id")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

}
