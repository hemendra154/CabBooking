package com.hs.cabbooking.serviceImpl;

import com.hs.cabbooking.dto.requestDTO.PaymentRequestDTO;
import com.hs.cabbooking.dto.requestDTO.PaymentStatusDTO;
import com.hs.cabbooking.dto.responseDTO.PaymentResponseDTO;
import com.hs.cabbooking.entity.Booking;
import com.hs.cabbooking.entity.Payment;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.repository.BookingRepository;
import com.hs.cabbooking.repository.PaymentRepository;
import com.hs.cabbooking.service.PaymentService;
import com.hs.cabbooking.utility.enums.PaymentMode;
import com.hs.cabbooking.utility.enums.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO requestDTO) throws CabBookingException {

        Booking booking = bookingRepository.findById(requestDTO.getBookingId())
                .orElseThrow(()-> new CabBookingException("Booking not found!"));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setPaymentMethod(PaymentMode.valueOf(requestDTO.getPaymentMethod()));
        payment.setAmount(requestDTO.getAmount());
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setTransactionId("TXN_" + System.currentTimeMillis());

        Payment newPayment = paymentRepository.save(payment);

        return objectMapper(newPayment);
    }

    @Override
    public PaymentResponseDTO getPaymentDetails(Integer paymentId) throws CabBookingException{
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() ->  new CabBookingException("Invalid Payment ID"));

        return objectMapper(payment);
    }

    @Override
    public PaymentResponseDTO updatePaymentStatus(PaymentStatusDTO paymentStatusDTO) throws CabBookingException{
        Payment payment = paymentRepository.findById(paymentStatusDTO.getPaymentId())
                .orElseThrow(() ->  new CabBookingException("Invalid Payment ID"));

        payment.setPaymentStatus(PaymentStatus.valueOf(paymentStatusDTO.getPaymentStatus()));

        Payment updatedPayment = paymentRepository.save(payment);

        return objectMapper(updatedPayment);
    }

    private PaymentResponseDTO objectMapper(Payment payment){
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();

        paymentResponseDTO.setPaymentId(payment.getPaymentId());
        paymentResponseDTO.setBookingId(payment.getBooking().getBookingId());
        paymentResponseDTO.setAmount(payment.getAmount());
        paymentResponseDTO.setPaymentMethod(payment.getPaymentMethod().name());
        paymentResponseDTO.setPaymentStatus(payment.getPaymentStatus().name());
        paymentResponseDTO.setPaymentDate(payment.getPaymentTime());
        paymentResponseDTO.setTransactionId(payment.getTransactionId());


        return paymentResponseDTO;
    }
}
