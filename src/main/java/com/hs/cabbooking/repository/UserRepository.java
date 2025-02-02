package com.hs.cabbooking.repository;

import com.hs.cabbooking.entity.Booking;
import com.hs.cabbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     Optional<User> findByEmail(String email);
     boolean existsByEmail(String email);
}
