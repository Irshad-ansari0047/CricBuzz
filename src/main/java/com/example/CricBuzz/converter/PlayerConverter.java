package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.PlayerRequestDto;
import com.example.CricBuzz.dto.response.PlayerResponseDto;
import com.example.CricBuzz.model.Player;

public class PlayerConverter {

    public static Player convertPlayerRequestDtoToPlayer(PlayerRequestDto playerRequestDto) {
        return Player.builder().
                name(playerRequestDto.getName()).
                gender(playerRequestDto.getGender()).
                speciality(playerRequestDto.getSpeciality()).
                email(playerRequestDto.getEmail()).
                build();

    }

    public static PlayerResponseDto convertPlayerToPlayerResponseDto(Player player) {

        return PlayerResponseDto.builder()
                .name(player.getName())
                .gender(player.getGender())
                .speciality(player.getSpeciality())
                .build();
    }
}
