package com.hs.cabbooking.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponseDTO {

    private Integer paymentId;
    private Integer bookingId;
    private String paymentMethod;
    private Double amount;
    private String paymentStatus;
    private String transactionId;
    private LocalDateTime paymentDate;

}
