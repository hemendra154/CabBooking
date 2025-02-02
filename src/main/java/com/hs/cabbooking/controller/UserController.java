package com.hs.cabbooking.controller;

import com.hs.cabbooking.dto.requestDTO.LoginRequestDTO;
import com.hs.cabbooking.dto.requestDTO.UserRequestDTO;
import com.hs.cabbooking.dto.responseDTO.UserResponseDTO;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Validated @RequestBody UserRequestDTO requestDTO) throws CabBookingException {
        UserResponseDTO userResponseDTO = userService.registerUser(requestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@Validated @RequestBody LoginRequestDTO requestDTO) throws CabBookingException{
        UserResponseDTO userResponseDTO = userService.loginUser(requestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserByID(@PathVariable(name = "id") Integer userId) throws CabBookingException {
        UserResponseDTO userResponseDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable(name = "id") Integer userId, @Validated @RequestBody UserRequestDTO requestDTO) throws CabBookingException {
        UserResponseDTO userResponseDTO = userService.updateUser(userId, requestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<UserResponseDTO> deactivateUser(@PathVariable(name = "id") Integer userId) throws CabBookingException {
        UserResponseDTO userResponseDTO = userService.deactivateUser(userId);
        return ResponseEntity.ok(userResponseDTO);
    }

    //TODO add API to fetch all the USers, and to reset the password


}
