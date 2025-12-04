package com.example.CricBuzz.dto.request;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileRequestDto {

    int matchesPlayed;

    int runsScored;

    int wicketsTaken;

    double battingAvg;

    double bowlingAvg;
}
