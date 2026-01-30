package com.example.CricBuzz.service;

import com.example.CricBuzz.converter.CricketMatchConverter;
import com.example.CricBuzz.dto.request.CricketMatchRequestDto;
import com.example.CricBuzz.dto.response.CricketMatchResponseDto;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.model.CricketMatch;
import com.example.CricBuzz.model.Series;
import com.example.CricBuzz.model.Team;
import com.example.CricBuzz.repository.CricketMatchRepository;
import com.example.CricBuzz.repository.SeriesRepository;
import com.example.CricBuzz.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CricketMatchService {

    private final CricketMatchRepository cricketMatchRepository;
    private final TeamRepository teamRepository;
    private final SeriesRepository seriesRepository;

    public CricketMatchService(CricketMatchRepository cricketMatchRepository, TeamRepository teamRepository, SeriesRepository seriesRepository) {
        this.cricketMatchRepository = cricketMatchRepository;
        this.teamRepository = teamRepository;
        this.seriesRepository = seriesRepository;
    }

    // create match with two teams(teamA & teamB) inside series
    @Transactional
    public CricketMatchResponseDto registerMatch(CricketMatchRequestDto cricketMatchRequestDto,
                                                 int teamAId,
                                                 int teamBId,
                                                 int seriesId) {

        if (teamAId == teamBId) {
            throw new RuntimeException("Both teams cannot be same");
        }

        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new RuntimeException("Series not found"));

        Team teamA = teamRepository.findById(teamAId)
                .orElseThrow(() -> new TeamNotFoundException("TeamA_id is invalid"));

        Team teamB = teamRepository.findById(teamBId)
                .orElseThrow(() -> new TeamNotFoundException("TeamB_id is invalid"));

        CricketMatch cricketMatch =
                CricketMatchConverter.convertCricketMatchRequestDtoToCricketMatch(cricketMatchRequestDto);
        List<Team> teams = new ArrayList<>();
        teams.add(teamA);
        teams.add(teamB);

        cricketMatch.setTeams(teams);
        cricketMatch.setSeriesName(series);

        //maintain reverse relation
        if (teamA.getMatches() != null) {
            teamA.getMatches().add(cricketMatch);
        }
        if (teamB.getMatches() != null) {
            teamB.getMatches().add(cricketMatch);
        }

        CricketMatch saved = cricketMatchRepository.save(cricketMatch);

        return CricketMatchConverter.convertCricketMatchToCricketMatchResponseDto(saved);
    }
}
