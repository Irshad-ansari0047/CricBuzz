package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.ProfileRequestDto;
import com.example.CricBuzz.dto.response.ProfileResponseDto;
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

    public static ProfileResponseDto convertPlayerProfileToProfileResponseDto(PlayerProfile playerProfile){

        return ProfileResponseDto.builder()
                .matchesPlayed(playerProfile.getMatchesPlayed())
                .runsScored(playerProfile.getRunsScored())
                .wicketsTaken(playerProfile.getWicketsTaken())
                .battingAvg(playerProfile.getBattingAvg())
                .bowlingAvg(playerProfile.getBowlingAvg())
                .player(PlayerConverter.convertPlayerToPlayerResponseDto(playerProfile.getPlayer()))
                .build();
    }


}
