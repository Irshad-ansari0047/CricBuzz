package com.example.CricBuzz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {

    private String name;
    private int ranking;
    private int iccPoints;
    private String coach;
    private List<PlayerResponseDto> players;
}
