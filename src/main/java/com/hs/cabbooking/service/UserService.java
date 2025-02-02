package com.hs.cabbooking.service;

import com.hs.cabbooking.dto.requestDTO.LoginRequestDTO;
import com.hs.cabbooking.dto.requestDTO.UserRequestDTO;
import com.hs.cabbooking.dto.responseDTO.UserResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;

public interface UserService {

    UserResponseDTO registerUser(UserRequestDTO user) throws CabBookingException;

    UserResponseDTO loginUser(LoginRequestDTO loginRequestDTO) throws  CabBookingException;

    UserResponseDTO getUserById(Integer userId) throws  CabBookingException;

    UserResponseDTO updateUser(Integer userId, UserRequestDTO userRequestDTO) throws  CabBookingException;

    UserResponseDTO deactivateUser(Integer userId) throws  CabBookingException;
}
