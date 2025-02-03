package com.hs.cabbooking.dto.requestDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PaymentStatusDTO {

    @NotNull(message = "paymentId is required")
    @Min(value = 1, message = "Payment Id must be a positive number")
    private Integer paymentId;

    @NotNull(message = "PaymentStatus is required")
    @Pattern(regexp = "^(PENDING|COMPLETED|FAILED)$", message = "Invalid Status, Please select PENDING, COMPLETED or FAILED")
    private String paymentStatus;
}
