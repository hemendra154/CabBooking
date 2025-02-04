package com.hs.cabbooking.repository;

import com.hs.cabbooking.entity.Booking;
import com.hs.cabbooking.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

    Optional<Cab> findCabByCabId(Integer cabId);

}
