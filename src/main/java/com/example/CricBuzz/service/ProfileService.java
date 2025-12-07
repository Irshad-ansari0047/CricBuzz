package com.example.CricBuzz.service;

import com.example.CricBuzz.converter.ProfileConverter;
import com.example.CricBuzz.dto.request.ProfileRequestDto;
import com.example.CricBuzz.dto.response.ProfileResponseDto;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.PlayerProfile;
import com.example.CricBuzz.repository.PlayerRepository;
import com.example.CricBuzz.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ProfileRepository profileRepository;

    public ProfileResponseDto addProfile(ProfileRequestDto profileRequestDto, int playerId) {
        Player player = playerRepository.findById(playerId).get();
        if(player != null) {
           PlayerProfile profile = ProfileConverter.convertProfileRequestDtoToPlayerProfile(profileRequestDto);

           player.setPlayerProfile(profile);
           profile.setPlayer(player);

           PlayerProfile savedProfile = profileRepository.save(profile);
           return ProfileConverter.convertPlayerProfileToProfileResponseDto(savedProfile);
        }
        else {
            throw new PlayerNotFoundException("Invalid Player Id");
        }
    }

    public ProfileResponseDto getPlayerProfile(int playerId) {
        Player player = playerRepository.findById(playerId).get();
        if(player == null){
            throw new PlayerNotFoundException("Invalid Player Id");
        }
        PlayerProfile profile = player.getPlayerProfile();
        return ProfileConverter.convertPlayerProfileToProfileResponseDto(profile);
    }

    public String deleteProfile(int profileId) {
        PlayerProfile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new PlayerNotFoundException("Profile not found with id: " + profileId));

        Player player = profile.getPlayer();
        player.setPlayerProfile(null);
        profileRepository.deleteById(profileId);

        return "Profile with id : "+profileId+" got deleted";
    }

    public ProfileResponseDto updateProfile(int playerId, ProfileRequestDto profileRequestDto) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Invalid Player Id"));

        PlayerProfile profile = player.getPlayerProfile();
        if(profile != null) {
            profile.setMatchesPlayed(profileRequestDto.getMatchesPlayed());
            profile.setRunsScored(profileRequestDto.getRunsScored());
            profile.setWicketsTaken(profileRequestDto.getWicketsTaken());
            profile.setBattingAvg(profileRequestDto.getBattingAvg());
            profile.setBowlingAvg(profileRequestDto.getBowlingAvg());
            PlayerProfile savedProfile = profileRepository.save(profile);

            return ProfileConverter.convertPlayerProfileToProfileResponseDto(savedProfile);
        }else {
            throw new RuntimeException("Profile not found for the player with id: " + playerId);
        }
    }
}
