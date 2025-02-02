package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookingRequestDTO {

    @NotBlank(message = "Customer Detail is required")
    private Integer customerId;

    @NotBlank(message = "Cab Detail is required")
    private Integer cabId;

    @NotBlank(message = "pickupLocation is required")
    private String pickupLocation;

    @NotBlank(message = "dropoffLocation is required")
    private String dropoffLocation;

    @NotBlank(message = "User name is required")
    @Min(value = 1, message = "Fare must be at least 1")
    private double fare;
}
