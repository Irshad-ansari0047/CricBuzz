package com.example.CricBuzz.service;

import com.example.CricBuzz.converter.PlayerConverter;
import com.example.CricBuzz.dto.request.PlayerRequestDto;
import com.example.CricBuzz.dto.response.PlayerResponseDto;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponseDto addPlayer(PlayerRequestDto playerRequestDto) {
        Player player = PlayerConverter.convertPlayerRequestDtoToPlayer(playerRequestDto);

        Player savedPlayer = playerRepository.save(player);
        return PlayerConverter.convertPlayerToPlayerResponseDto(savedPlayer);
    }

    public PlayerResponseDto getPlayerById(int playerId) {
        Player player = playerRepository.findById(playerId).get();
        if(player == null){
            throw new PlayerNotFoundException("invalid Player id");
        }
        return PlayerConverter.convertPlayerToPlayerResponseDto(player);
    }

    public List<PlayerResponseDto> getAllPlayer() {
        List<Player> playerList = playerRepository.findAll();

        if(playerList.isEmpty()){
            throw new RuntimeException("no palyer is present");
        }

        List<PlayerResponseDto> playerResponses = new ArrayList<>();
        for(Player player : playerList){
            playerResponses.add(PlayerConverter.convertPlayerToPlayerResponseDto(player));
        }
        return playerResponses;
    }

    public String deletePlayerId(int playerId) {
        playerRepository.deleteById(playerId);
        return "player with id : "+playerId+ " got deleted";
    }

    public PlayerResponseDto updatePlayerById(int playerId, PlayerRequestDto playerRequestDto) {
        Player player = playerRepository.findById(playerId).get();

        if(player != null){
            player.setName(playerRequestDto.getName());
            player.setGender(playerRequestDto.getGender());
            player.setSpeciality(playerRequestDto.getSpeciality());
            player.setEmail(playerRequestDto.getEmail());

            Player savedPlayer = playerRepository.save(player);
            return PlayerConverter.convertPlayerToPlayerResponseDto(savedPlayer);
        }else {
            throw new PlayerNotFoundException("player id is invalid");
        }
    }
}
