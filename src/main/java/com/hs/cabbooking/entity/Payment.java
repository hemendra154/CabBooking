package com.hs.cabbooking.entity;

import com.hs.cabbooking.utility.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId", nullable = false)
    private Booking booking;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMode paymentMethod;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double amount;

    @Column(nullable = false, updatable = false)
    private LocalDateTime paymentTime = LocalDateTime.now();
}
