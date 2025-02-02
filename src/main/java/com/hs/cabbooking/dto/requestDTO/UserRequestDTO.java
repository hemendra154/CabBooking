package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "User name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email Id")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 character long")
    private String password;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Please enter a valid phoneNumber")
    private String phoneNumber;

    private boolean isActive = true;

}
