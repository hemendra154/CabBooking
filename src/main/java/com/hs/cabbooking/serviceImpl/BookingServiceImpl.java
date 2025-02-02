package com.hs.cabbooking.serviceImpl;

import com.hs.cabbooking.dto.requestDTO.BookingRequestDTO;
import com.hs.cabbooking.dto.requestDTO.BookingStatusUpdateDTO;
import com.hs.cabbooking.dto.responseDTO.BookingResponseDTO;
import com.hs.cabbooking.entity.Booking;
import com.hs.cabbooking.entity.Cab;
import com.hs.cabbooking.entity.User;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.repository.BookingRepository;
import com.hs.cabbooking.repository.CabRepository;
import com.hs.cabbooking.repository.UserRepository;
import com.hs.cabbooking.service.BookingService;
import com.hs.cabbooking.utility.enums.BookingStatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) throws CabBookingException {

        User customer = userRepository.findById(bookingRequestDTO.getCustomerId())
                .orElseThrow(() -> new CabBookingException("Customer Not Found"));

        Cab cab = cabRepository.findCabById(bookingRequestDTO.getCabId())
                .orElseThrow(() -> new CabBookingException("Cab Not Found"));

        if(!cab.getIsAvailable()){
            throw new CabBookingException("Cab Is Not Available");
        }

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setCab(cab);
        booking.setPickupLocation(bookingRequestDTO.getPickupLocation());
        booking.setDropoffLocation(bookingRequestDTO.getDropoffLocation());
        booking.setFare(bookingRequestDTO.getFare());
        booking.setStatus(BookingStatus.PENDING);
        booking.setBookingTime(LocalDateTime.now());

        bookingRepository.save(booking);

        cab.setIsAvailable(false);
        cabRepository.save(cab);

        return objectMapper(booking);
    }

    @Override
    public BookingResponseDTO getBookingById(Integer bookingId) throws CabBookingException {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new CabBookingException("Cab Not Found"));
        return objectMapper(booking);
    }

    @Override
    public BookingResponseDTO updateBooking(Integer bookingId, BookingStatusUpdateDTO bookingRequestDTO) throws CabBookingException{
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new CabBookingException("Booking not found"));

        booking.setStatus(BookingStatus.valueOf(bookingRequestDTO.getStatus()));

        if(booking.getStatus() == BookingStatus.COMPLETED){
            Cab cab = booking.getCab();
            cab.setIsAvailable(true);
            cabRepository.save(cab);
        }

        bookingRepository.save(booking);

        return objectMapper(booking);
    }

    @Override
    public List<BookingResponseDTO> getAllBookingByCustomer(Integer customerId) throws CabBookingException{
        List<Booking> bookings = bookingRepository.findBookingByCustomerUserId(customerId);
        if(bookings.isEmpty()){
            throw  new CabBookingException("Not Bookings");
        }

        return bookings.stream().map(this::objectMapper).toList();
    }

    private BookingResponseDTO objectMapper(Booking booking){
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();

        bookingResponseDTO.setBookingId(booking.getBookingId());
        bookingResponseDTO.setCustomerId(booking.getCustomer().getUserId());
        bookingResponseDTO.setCabId(booking.getCab().getCabId());
        bookingResponseDTO.setFare(booking.getFare());
        bookingResponseDTO.setPickupLocation(booking.getPickupLocation());
        bookingResponseDTO.setDropoffLocation(booking.getDropoffLocation());
        bookingResponseDTO.setStatus(booking.getStatus().name());
        bookingResponseDTO.setBookingTime(booking.getBookingTime());

        return bookingResponseDTO;
    }
}
