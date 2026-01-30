package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.LoginRequestDto;
import com.example.CricBuzz.dto.request.RegisterRequestDto;
import com.example.CricBuzz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to User page";
    }

    @PostMapping("/register")
    public String addUser(@RequestBody RegisterRequestDto registerRequestDto) {
        return userService.registerUser(registerRequestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            return new ResponseEntity<>(userService.loginUser(loginRequestDto), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
