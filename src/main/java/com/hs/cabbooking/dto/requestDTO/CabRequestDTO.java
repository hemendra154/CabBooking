package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CabRequestDTO {

    @NotBlank(message = "Cab Number is required")
    private String cabNumber;

    @NotBlank(message = "cabType is required")
    private String cabType;

    @NotNull(message = "Please mention the availability")
    private Boolean isAvailable;

    @NotNull(message = "DriverId is required")
    private Integer driverId;
}
