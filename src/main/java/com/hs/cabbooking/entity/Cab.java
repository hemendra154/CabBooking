package com.hs.cabbooking.entity;

import com.hs.cabbooking.utility.enums.CabType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cabs")
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cabId;

	@Column(nullable = false, unique = true)
	private String cabNumber;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CabType cabType;

	@Column(unique = true)
	private Boolean isAvailable = true;

	@OneToOne
	@JoinColumn(name = "driver_id", referencedColumnName = "userId")
	private User driver;

	private LocalDateTime createdAt = LocalDateTime.now();

}