package com.hs.cabbooking.dto.responseDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {

    private Integer bookingId;
    private Integer customerId;
    private Integer cabId;
    private String pickupLocation;
    private String dropoffLocation;
    private Double fare;
    private String status;
    private LocalDateTime bookingTime;
}
