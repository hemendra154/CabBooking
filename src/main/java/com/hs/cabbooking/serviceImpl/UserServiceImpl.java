package com.hs.cabbooking.serviceImpl;

import com.hs.cabbooking.dto.requestDTO.LoginRequestDTO;
import com.hs.cabbooking.dto.requestDTO.UserRequestDTO;
import com.hs.cabbooking.dto.responseDTO.UserResponseDTO;
import com.hs.cabbooking.entity.User;
import com.hs.cabbooking.exception.CabBookingException;
import com.hs.cabbooking.repository.UserRepository;
import com.hs.cabbooking.service.UserService;
import com.hs.cabbooking.utility.enums.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDTO registerUser(UserRequestDTO user) throws CabBookingException {

        if(userRepository.existsByEmail(user.getEmail())){
            throw new CabBookingException("Email already in use, Please login!");
        }

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setIsActive(user.isActive());
        newUser.setRole(Role.valueOf(user.getRole()));


        newUser = userRepository.save(newUser);

        return objectMapper(newUser);
    }

    @Override
    public UserResponseDTO loginUser(LoginRequestDTO loginRequestDTO) throws CabBookingException {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new CabBookingException("Invalid email or password"));

        if(!passwordEncoder.matches(user.getPassword(), loginRequestDTO.getPassword())){
            throw new CabBookingException("Invalid email or password");
        }

        return objectMapper(user);
    }

    @Override
    public UserResponseDTO getUserById(Integer userId) throws CabBookingException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CabBookingException("User not found!"));

        return objectMapper(user);
    }

    @Override
    public UserResponseDTO updateUser(Integer userId, UserRequestDTO userRequestDTO) throws CabBookingException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CabBookingException("User not found!"));

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        if(userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()){
            user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        }
        user.setIsActive(userRequestDTO.isActive());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setRole(Role.valueOf(userRequestDTO.getRole()));

        userRepository.save(user);

        return objectMapper(user);
    }

    @Override
    public UserResponseDTO deactivateUser(Integer userId) throws CabBookingException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CabBookingException("User not found!"));

        user.setIsActive(false);

        userRepository.save(user);

        return objectMapper(user);
    }

    private UserResponseDTO objectMapper(User user){
        UserResponseDTO response = new UserResponseDTO();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setCreatedAt(user.getCreatedAt());
        response.setActive(user.getIsActive());
        return response;
    }
}
