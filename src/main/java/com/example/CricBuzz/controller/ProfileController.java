package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.ProfileRequestDto;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/save")
    public ResponseEntity<?> addProfile(@RequestBody ProfileRequestDto profileRequestDto, @RequestParam("playerId") int playerId) {
        try {
            return new ResponseEntity<>(profileService.addProfile(profileRequestDto, playerId), HttpStatus.OK);
        }
        catch(PlayerNotFoundException e){
            return ResponseEntity.badRequest().body("Invalid Player Id");
        }
    }

    @GetMapping("/find")
    public ResponseEntity<?> getPlayerProfile(@RequestParam("playerId") int playerId) {
        try {
            return new ResponseEntity<>(profileService.getPlayerProfile(playerId), HttpStatus.OK);
        }catch (PlayerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable("profileId") int profileId) {
        return ResponseEntity.ok().body(profileService.deleteProfile(profileId));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestParam("playerId") int playerId, @RequestBody ProfileRequestDto profileRequestDto) {
        try {
            return new ResponseEntity<>(profileService.updateProfile(playerId, profileRequestDto),HttpStatus.CREATED);
        }catch(PlayerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
