package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BookingStatusUpdateDTO {

    @NotNull(message = "Status is required")
    @Pattern(regexp = "PENDING|CONFIRMED|COMPLETED|CANCELLED", message = "Invalid Booking Status")
    private String status;
}
