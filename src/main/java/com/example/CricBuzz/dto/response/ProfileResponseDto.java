package com.example.CricBuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileResponseDto {

    int matchesPlayed;

    int runsScored;

    int wicketsTaken;

    double battingAvg;

    double bowlingAvg;

    PlayerResponseDto player;
}
