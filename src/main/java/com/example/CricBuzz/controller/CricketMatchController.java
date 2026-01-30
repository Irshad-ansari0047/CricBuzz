package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.CricketMatchRequestDto;
import com.example.CricBuzz.dto.response.CricketMatchResponseDto;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.service.CricketMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
@RequiredArgsConstructor
public class CricketMatchController {

    private final CricketMatchService cricketMatchService;
    @PostMapping("/register")
    public ResponseEntity registerMatch(@RequestBody CricketMatchRequestDto cricketMatchRequestDto,
                                        @RequestParam("teamA-id") int teamAId,
                                        @RequestParam("teamB-id") int teamBId,
                                        @RequestParam("series-id") int seriesId) {
        try{
            return new ResponseEntity<>(cricketMatchService.registerMatch(cricketMatchRequestDto,teamAId,teamBId,seriesId),
                    HttpStatus.CREATED);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
