package com.hs.cabbooking.serviceImpl;

import com.hs.cabbooking.dto.requestDTO.CabRequestDTO;
import com.hs.cabbooking.dto.responseDTO.CabResponseDTO;
import com.hs.cabbooking.entity.Cab;
import com.hs.cabbooking.entity.User;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.repository.CabRepository;
import com.hs.cabbooking.service.CabService;
import com.hs.cabbooking.utility.enums.CabType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CabServiceImpl implements CabService {

    @Autowired
    CabRepository cabRepository;

    public CabResponseDTO addCab(CabRequestDTO cabRequestDTO) throws CabBookingException {
        Cab cab = new Cab();
        cab.setCabNumber(cabRequestDTO.getCabNumber());
        cab.setCabType(CabType.valueOf(cabRequestDTO.getCabType()));
        cab.setDriver(new User(cabRequestDTO.getDriverId()));
        cab.setIsAvailable(cabRequestDTO.getIsAvailable());
        cab.setCreatedAt(LocalDateTime.now());

        Cab savedCab = cabRepository.save(cab);
        if(cab == null){
            throw new CabBookingException("Error Occurred");
        }else{
            return objectMapper(cab);
        }
    }

    public CabResponseDTO getCabByID(Integer cabId) throws CabBookingException {
        Cab cabOptional = cabRepository.findCabByCabId(cabId)
                .orElseThrow(() -> new CabBookingException("Cab Not Found"));

        return objectMapper(cabOptional);
    }

    public List<CabResponseDTO> getAllCabs() throws CabBookingException {
        List<Cab> cabs = cabRepository.findAll();
        if(cabs.isEmpty())
            throw new CabBookingException("No Cab are available");
        return cabs.stream().map(this::objectMapper).toList();
    }

    public boolean setCabAvailability(Integer cabId, boolean availability) throws CabBookingException {
        Optional<Cab> cabOptional = cabRepository.findCabByCabId(cabId);
        if(cabOptional.isPresent()){
            Cab cab =  cabOptional.get();
            cab.setIsAvailable(availability);
            cabRepository.save(cab);
            return true;
        }else{
            throw new CabBookingException("Cab Not Found");
        }
    }

    private CabResponseDTO objectMapper(Cab cab){
        CabResponseDTO response = new CabResponseDTO();
        response.setCabId(cab.getCabId());
        response.setCabNumber(cab.getCabNumber());
        response.setCabType(cab.getCabType().name());
        response.setDriverId(cab.getDriver().getUserId());
        response.setCreatedAt(cab.getCreatedAt());
        response.setIsAvailable(cab.getIsAvailable());
        return response;
    }
}
