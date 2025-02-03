package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PaymentRequestDTO {

    @NotNull(message = "Booking ID is required")
    @Min(value = 1, message = "Booking ID must be positive")
    private Integer bookingId;

    @NotNull(message = "PaymentMethod is required")
    @Pattern(regexp = "^(CASH|CARD|UPI)$", message = "Payment mode is invalid")
    private String paymentMethod;

    @NotNull(message = "Amount is required")
    private Double amount;
}
