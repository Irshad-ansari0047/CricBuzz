package com.example.CricBuzz.service;

import com.example.CricBuzz.converter.TeamConverter;
import com.example.CricBuzz.dto.request.TeamRequestDto;
import com.example.CricBuzz.dto.response.TeamResponseDto;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.Team;
import com.example.CricBuzz.repository.PlayerRepository;
import com.example.CricBuzz.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        Team team = TeamConverter.convertTeamRequestDtoToTeam(teamRequestDto);
        Team savedTeam = teamRepository.save(team);
        return TeamConverter.convertTeamToTeamResponseDto(savedTeam);
    }

    public TeamResponseDto getTeamById(int teamId) {
        // Logic to get team by ID here
        Team team = teamRepository.findById(teamId).
                orElseThrow(() -> new RuntimeException("Team not found"));

        return TeamConverter.convertTeamToTeamResponseDto(team);
    }

    public List<TeamResponseDto> getAllTeams() {
        List<Team> teamList = teamRepository.findAll();
        if(teamList.isEmpty()){
            throw new TeamNotFoundException("Team not found");
        }

        List<TeamResponseDto> teamResponseDtoList = new ArrayList<>();
        for(Team team : teamList){
            teamResponseDtoList.add(TeamConverter.convertTeamToTeamResponseDto(team));
        }
        return teamResponseDtoList;
    }

    public TeamResponseDto updateTeam(TeamRequestDto teamRequestDto, int teamId) {
        Team team = teamRepository.findById(teamId).
                orElseThrow(() -> new TeamNotFoundException("Team not found"));

        team.setName(teamRequestDto.getName());
        team.setRanking(teamRequestDto.getRanking());
        team.setIccPoints(teamRequestDto.getIccPoints());
        team.setCoach(teamRequestDto.getCoach());
        Team savedTeam = teamRepository.save(team);

        return TeamConverter.convertTeamToTeamResponseDto(savedTeam);
    }

    public String deleteTeam(int teamId) {
        if(!teamRepository.existsById(teamId)){
            throw new TeamNotFoundException("Invalid team id. So team not found");
        }

        teamRepository.deleteById(teamId);
        return "Team deleted successfully with teamId: "+ teamId;
    }

    public TeamResponseDto addPlayerToTeam(int teamId, int playerId) {
        Team team = teamRepository.findById(teamId).
                orElseThrow(() -> new TeamNotFoundException("Team not found"));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));

        player.setTeam(team);
        team.getPlayerList().add(player);

        Team savedTeam = teamRepository.save(team);
        return TeamConverter.convertTeamToTeamResponseDto(savedTeam);
    }
}
