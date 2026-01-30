package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.TeamRequestDto;
import com.example.CricBuzz.dto.response.PlayerResponseDto;
import com.example.CricBuzz.dto.response.TeamResponseDto;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamConverter {

    public static Team convertTeamRequestDtoToTeam(TeamRequestDto teamRequestDto){
        return Team.builder()
                .name(teamRequestDto.getName())
                .ranking(teamRequestDto.getRanking())
                .iccPoints(teamRequestDto.getIccPoints())
                .coach(teamRequestDto.getCoach())
                .build();
    }

    public static TeamResponseDto convertTeamToTeamResponseDto(Team team){

        List<PlayerResponseDto> players = new ArrayList<>();

        if (team.getPlayerList() != null) {
            for (Player player : team.getPlayerList()) {
                PlayerResponseDto dto =
                        PlayerConverter.convertPlayerToPlayerResponseDto(player);
                players.add(dto);
            }
        }

        return TeamResponseDto.builder()
                .name(team.getName())
                .ranking(team.getRanking())
                .iccPoints(team.getIccPoints())
                .coach(team.getCoach())
                .players(players)
                .build();
    }
}
