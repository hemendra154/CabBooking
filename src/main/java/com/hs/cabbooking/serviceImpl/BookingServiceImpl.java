package com.hs.cabbooking.serviceImpl;

import com.hs.cabbooking.dto.requestDTO.BookingRequestDTO;
import com.hs.cabbooking.dto.requestDTO.BookingStatusUpdateDTO;
import com.hs.cabbooking.dto.responseDTO.BookingResponseDTO;
import com.hs.cabbooking.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        return null;
    }

    @Override
    public BookingResponseDTO getBookingById(Integer bookingId) {
        return null;
    }

    @Override
    public BookingResponseDTO updateBooking(Integer bookingId, BookingStatusUpdateDTO bookingRequestDTO) {
        return null;
    }

    @Override
    public List<BookingResponseDTO> getAllBookingByCustomer(Integer bookingId) {
        return null;
    }
}
