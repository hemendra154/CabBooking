package com.hs.cabbooking.service;

import com.hs.cabbooking.dto.requestDTO.BookingRequestDTO;
import com.hs.cabbooking.dto.requestDTO.BookingStatusUpdateDTO;
import com.hs.cabbooking.dto.responseDTO.BookingResponseDTO;

import java.util.List;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO);

    BookingResponseDTO getBookingById(Integer bookingId);

    BookingResponseDTO updateBooking(Integer bookingId, BookingStatusUpdateDTO bookingRequestDTO);

    List<BookingResponseDTO> getAllBookingByCustomer(Integer bookingId);
}
