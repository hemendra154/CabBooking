package com.hs.cabbooking.controller;

import com.hs.cabbooking.dto.requestDTO.BookingRequestDTO;
import com.hs.cabbooking.dto.requestDTO.BookingStatusUpdateDTO;
import com.hs.cabbooking.dto.responseDTO.BookingResponseDTO;
import com.hs.cabbooking.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PutMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO){
        BookingResponseDTO bookingResponseDTO = bookingService.createBooking(bookingRequestDTO);
        return new ResponseEntity<>(bookingResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Integer bookingId){
        BookingResponseDTO bookingResponseDTO = bookingService.getBookingById(bookingId);
        return new ResponseEntity<>(bookingResponseDTO, HttpStatus.FOUND);
    }

    @PatchMapping("/{bookingId}/status")
    public ResponseEntity<BookingResponseDTO> updatingBooking(@PathVariable Integer bookingId, @Valid @RequestBody BookingStatusUpdateDTO bookingRequestDTO){
        BookingResponseDTO bookingResponseDTO = bookingService.updateBooking(bookingId, bookingRequestDTO);
        return new ResponseEntity<>(bookingResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<BookingResponseDTO>> getAllBookingByCustomer(@PathVariable Integer customerId){
        List<BookingResponseDTO> bookingResponseDTO = bookingService.getAllBookingByCustomer(customerId);
        return new ResponseEntity<>(bookingResponseDTO, HttpStatus.FOUND);
    }

}
