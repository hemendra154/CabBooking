package com.hs.cabbooking.entity;

import com.hs.cabbooking.utility.enums.PaymentMode;
import com.hs.cabbooking.utility.enums.PaymentStatus;
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

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "userId", nullable = false)
    private User customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMode paymentMethod;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @Column(unique = true)
    private String transactionId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime paymentTime = LocalDateTime.now();
}
