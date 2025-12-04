package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.TeamRequestDto;
import com.example.CricBuzz.model.Team;

public class TeamConverter {

    public static Team convertTeamRequestDtoToTeam(TeamRequestDto teamRequestDto){
        return Team.builder()
                .name(teamRequestDto.getName())
                .ranking(teamRequestDto.getRanking())
                .iccPoints(teamRequestDto.getIccPoints())
                .coach(teamRequestDto.getCoach())
                .build();
    }
}
