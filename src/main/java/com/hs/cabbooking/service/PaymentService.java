package com.hs.cabbooking.service;

import com.hs.cabbooking.dto.requestDTO.PaymentRequestDTO;
import com.hs.cabbooking.dto.requestDTO.PaymentStatusDTO;
import com.hs.cabbooking.dto.responseDTO.PaymentResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;

public interface PaymentService {
    PaymentResponseDTO createPayment(PaymentRequestDTO requestDTO) throws CabBookingException;

    PaymentResponseDTO getPaymentDetails(Integer paymentId) throws CabBookingException;

    PaymentResponseDTO updatePaymentStatus(PaymentStatusDTO paymentStatusDTO) throws CabBookingException;

}
