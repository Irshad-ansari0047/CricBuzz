package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.PlayerRequestDto;
import com.example.CricBuzz.dto.response.PlayerResponseDto;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping("/save")
    public PlayerResponseDto addPlayer(@RequestBody PlayerRequestDto playerRequestDto){
        return playerService.addPlayer(playerRequestDto);

    }

    @GetMapping("/findById/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable("playerId") int  playerId){
        try {
//          PlayerResponseDto playerResponse = playerService.getPlayerById(playerId);
            return new ResponseEntity<>(playerService.getPlayerById(playerId),HttpStatus.OK);
        }
        catch(PlayerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllPlayer() {
        try {
            return new ResponseEntity<>(playerService.getAllPlayer(),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<?> deletePlayerId(@PathVariable("playerId") int playerId){
        return ResponseEntity.ok(playerService.deletePlayerId(playerId));
    }

    @PutMapping("/update/{playerId}")
    public ResponseEntity<?> updatePlayerById(@PathVariable("playerId") int playerId, @RequestBody PlayerRequestDto playerRequestDto) {
        try {
            return new ResponseEntity<>(playerService.updatePlayerById(playerId, playerRequestDto),HttpStatus.OK);
        }catch(PlayerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
}
