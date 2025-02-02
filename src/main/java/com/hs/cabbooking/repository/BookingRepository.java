package com.hs.cabbooking.repository;

import com.hs.cabbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findBookingByCustomerUserId(Integer customerId);

    Booking findBookingByCabCabId(Integer cabId);

}
