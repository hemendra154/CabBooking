package com.hs.cabbooking.service;

import com.hs.cabbooking.dto.requestDTO.CabRequestDTO;
import com.hs.cabbooking.dto.responseDTO.CabResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;

import java.util.List;

public interface CabService {
    public CabResponseDTO addCab(CabRequestDTO cabRequestDTO) throws CabBookingException;
    public CabResponseDTO getCabByID(Integer cabId) throws CabBookingException ;

    public List<CabResponseDTO> getAllCabs() throws CabBookingException ;

    public boolean setCabAvailability(Integer cabID, boolean availability) throws CabBookingException ;
}
