package com.hs.cabbooking.dto.requestDTO;

import lombok.Data;

@Data
public class CabAvailabilityDTO {
    private Integer cabId;
    private Boolean isAvailable;
}
