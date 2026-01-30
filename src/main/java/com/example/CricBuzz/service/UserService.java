package com.example.CricBuzz.service;

import com.example.CricBuzz.dto.request.LoginRequestDto;
import com.example.CricBuzz.dto.request.RegisterRequestDto;
import com.example.CricBuzz.enums.Role;
import com.example.CricBuzz.model.User;
import com.example.CricBuzz.repository.UserRepository;
import com.example.CricBuzz.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public String registerUser(RegisterRequestDto registerRequestDto) {
        if(userRepository.existsByUsername(registerRequestDto.getUsername())){
            return "Username already exists";
        }
        User user = User.builder()
                .username(registerRequestDto.getUsername())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .role(Role.valueOf(registerRequestDto.getRole()))
                .build();

        userRepository.save(user);
        return "User added successfully";
    }

    public String loginUser(LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                        loginRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            User user = userRepository.findByUsername(loginRequestDto.getUsername())
                    .orElseThrow();
            return jwtUtil.generateToken(user.getUsername(),user.getRole().name());
        }


            return "Invalid username or password";
    }
}
