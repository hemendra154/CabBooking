package com.hs.cabbooking.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {

    private Integer userId;
    private  String name;
    private String email;
    private String role;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private boolean isActive;
}
