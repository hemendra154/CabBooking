package com.hs.cabbooking.entity;

import com.hs.cabbooking.utility.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;

	@ManyToOne
	@JoinColumn( name = "customer_id", referencedColumnName = "userId", nullable = false)
	private User customer;

	@ManyToOne
	@JoinColumn(name = "cab_id", referencedColumnName = "cabId", nullable = false)
	private Cab cab;

	@Column(nullable = false)
	private String pickupLocation;

	@Column(nullable = false)
	private String dropoffLocation;

	@Column(nullable = false, precision = 10, scale = 2)
	private Double fare;

	@Enumerated(EnumType.STRING)
	private BookingStatus status = BookingStatus.PENDING;

	@Column(nullable = false, updatable = false)
	private LocalDateTime bookingTime = LocalDateTime.now();

}