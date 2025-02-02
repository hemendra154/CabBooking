package com.hs.cabbooking.service;

import com.hs.cabbooking.dto.requestDTO.BookingRequestDTO;
import com.hs.cabbooking.dto.requestDTO.BookingStatusUpdateDTO;
import com.hs.cabbooking.dto.responseDTO.BookingResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;

import java.util.List;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) throws CabBookingException;

    BookingResponseDTO getBookingById(Integer bookingId) throws CabBookingException;

    BookingResponseDTO updateBooking(Integer bookingId, BookingStatusUpdateDTO bookingRequestDTO) throws CabBookingException;

    List<BookingResponseDTO> getAllBookingByCustomer(Integer customerId) throws CabBookingException;
}
