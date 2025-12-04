package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.ProfileRequestDto;
import com.example.CricBuzz.model.PlayerProfile;

public class ProfileConverter {

    public static PlayerProfile convertProfileRequestDtoToPlayerProfile(ProfileRequestDto profileRequestDto){

        return PlayerProfile.builder()
                .matchesPlayed(profileRequestDto.getMatchesPlayed())
                .runsScored(profileRequestDto.getRunsScored())
                .wicketsTaken(profileRequestDto.getWicketsTaken())
                .battingAvg(profileRequestDto.getBattingAvg())
                .bowlingAvg(profileRequestDto.getBowlingAvg())
                .build();
    }


}
