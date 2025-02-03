package com.hs.cabbooking.controller;

import com.hs.cabbooking.dto.requestDTO.PaymentRequestDTO;
import com.hs.cabbooking.dto.requestDTO.PaymentStatusDTO;
import com.hs.cabbooking.dto.responseDTO.PaymentResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> createPayment(@Valid @RequestBody PaymentRequestDTO requestDTO) throws CabBookingException {
        PaymentResponseDTO response = paymentService.createPayment(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponseDTO> getPaymentDetails(@PathVariable Integer paymentId) throws CabBookingException{
        PaymentResponseDTO response = paymentService.getPaymentDetails(paymentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<PaymentResponseDTO> updatePaymentStatus(@Valid @RequestBody PaymentStatusDTO paymentStatusDTO) throws CabBookingException{
        PaymentResponseDTO response = paymentService.updatePaymentStatus(paymentStatusDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
