package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.CricketMatchRequestDto;
import com.example.CricBuzz.dto.response.CricketMatchResponseDto;
import com.example.CricBuzz.dto.response.TeamResponseDto;
import com.example.CricBuzz.model.CricketMatch;
import com.example.CricBuzz.model.Team;

import java.util.ArrayList;
import java.util.List;

public class CricketMatchConverter {

    public static CricketMatch convertCricketMatchRequestDtoToCricketMatch(CricketMatchRequestDto cricketMatchRequestDto){
        return CricketMatch.builder()
                .title(cricketMatchRequestDto.getTitle())
                .venue(cricketMatchRequestDto.getVenue())
                .noOfOvers(cricketMatchRequestDto.getNoOfOvers())
                .status(cricketMatchRequestDto.getStatus())
                .build();
    }

    public static CricketMatchResponseDto convertCricketMatchToCricketMatchResponseDto(CricketMatch cricketMatch){

        Team teamA = cricketMatch.getTeams().get(0);
        Team teamB = cricketMatch.getTeams().get(1);
        List<TeamResponseDto>  teams = new ArrayList<>();
        teams.add(TeamConverter.convertTeamToTeamResponseDto(teamA));
        teams.add(TeamConverter.convertTeamToTeamResponseDto(teamB));

        return CricketMatchResponseDto.builder()
                .title(cricketMatch.getTitle())
                .venue(cricketMatch.getVenue())
                .noOfOvers(cricketMatch.getNoOfOvers())
                .createdAt(cricketMatch.getCreatedAt())
                .status(cricketMatch.getStatus())
                .seriesName(cricketMatch.getSeriesName() == null ?
                        null : cricketMatch.getSeriesName().getName()
                        )
                .teams(teams)
                .build();
    }
}
