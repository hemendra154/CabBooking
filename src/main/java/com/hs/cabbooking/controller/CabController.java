package com.hs.cabbooking.controller;

import com.hs.cabbooking.dto.requestDTO.CabRequestDTO;
import com.hs.cabbooking.dto.responseDTO.CabResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabs")
public class CabController {

    @Autowired
    private CabService cabService;

    @PostMapping
    public ResponseEntity<CabResponseDTO> addCab(@Validated @RequestBody CabRequestDTO cabRequestDTO) throws CabBookingException {
        CabResponseDTO response = cabService.addCab(cabRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{cabId}")
    public ResponseEntity<CabResponseDTO> getCabById(@PathVariable Integer cabId) throws CabBookingException{
        CabResponseDTO response = cabService.getCabByID(cabId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CabResponseDTO>> getAllCabs() throws CabBookingException{
        List<CabResponseDTO> cabs = cabService.getAllCabs();
        return new ResponseEntity<>(cabs, HttpStatus.OK);
    }

    @PatchMapping("/{cabId}/availability")
    public ResponseEntity<String> setCabAvailability(@PathVariable Integer cabId, @RequestParam boolean availability) throws CabBookingException{
        Boolean updated = cabService.setCabAvailability(cabId,availability);
        return updated ? new ResponseEntity<>("Availability Updated", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
