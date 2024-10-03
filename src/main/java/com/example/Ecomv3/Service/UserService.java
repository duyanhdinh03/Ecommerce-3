package com.example.Ecomv3.Service;

import com.example.Ecomv3.DTO.ChangePasswordRequest;
import com.example.Ecomv3.Exception.ResourceNotFoundException;
import com.example.Ecomv3.Model.User;
import com.example.Ecomv3.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.USER);
        return userRepository.save(user);
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }
    public void changePassword(String email, ChangePasswordRequest request){
        User user = getUserByEmail(email);
        if(!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new BadCredentialsException("Current password is incorrect");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}

