package com.hs.cabbooking.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CabResponseDTO {

    private Integer cabId;
    private String cabNumber;
    private String cabType;
    private Boolean isAvailable;
    private Integer driverId;
    private LocalDateTime createdAt;
}
