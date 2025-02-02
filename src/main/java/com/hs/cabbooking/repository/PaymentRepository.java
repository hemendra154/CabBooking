package com.hs.cabbooking.repository;

import com.hs.cabbooking.entity.Booking;
import com.hs.cabbooking.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
