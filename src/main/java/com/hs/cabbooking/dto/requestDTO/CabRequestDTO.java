package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CabRequestDTO {

    @NotBlank(message = "Cab Number is required")
    private String cabNumber;

    @NotBlank(message = "cabType is required")
    private String cabType;

    @NotBlank(message = "Please mention the availability")
    private Boolean isAvailable;

    @NotBlank(message = "DriverId is required")
    private Integer driverId;
}
