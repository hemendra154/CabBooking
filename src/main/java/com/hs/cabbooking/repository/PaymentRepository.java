package com.hs.cabbooking.repository;

import com.hs.cabbooking.entity.Booking;
import com.hs.cabbooking.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // Find payment by transactionId (needed for external payment gateway)
    Optional<Payment> findPaymentByTransactionId(String transactionId);

}
