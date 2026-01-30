package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.TeamRequestDto;
import com.example.CricBuzz.dto.response.TeamResponseDto;
import com.example.CricBuzz.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/save")
    public ResponseEntity<?> addTeam(@RequestBody TeamRequestDto teamRequestDto) {
        try{
            return new ResponseEntity<>(teamService.createTeam(teamRequestDto), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{teamId}")
    public ResponseEntity<?> getTeamById(@PathVariable("teamId") int teamId){
        try{
            return new ResponseEntity<>(teamService.getTeamById(teamId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TeamResponseDto>> getAllTeams(){
        return new ResponseEntity<>(teamService.getAllTeams(),HttpStatus.OK);
    }

    @PutMapping("/update/{teamId}")
    public ResponseEntity<TeamResponseDto> updateTeam(@RequestBody TeamRequestDto teamRequestDto, @PathVariable("teamId") int teamId) {
        return new ResponseEntity<>(teamService.updateTeam(teamRequestDto, teamId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teamId}")
    public ResponseEntity<String>  deleteTeam(@PathVariable("teamId") int teamId) {
        return new ResponseEntity<>(teamService.deleteTeam(teamId),HttpStatus.OK);
    }

    @PutMapping("/addPlayerToTeam")
    public ResponseEntity<TeamResponseDto> assignPlayer(@RequestParam("teamId") int teamId, @RequestParam("playerId") int playerId) {

        return  new ResponseEntity<>(teamService.addPlayerToTeam(teamId, playerId), HttpStatus.OK);
    }
}
