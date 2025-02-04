package com.hs.cabbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ride_location")
public class RideLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId", nullable = false)
    private Booking booking;

    @Column(nullable = false, precision = 9)
    private Double latitude;

    @Column(nullable = false, precision = 9)
    private Double longitude;

    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}

