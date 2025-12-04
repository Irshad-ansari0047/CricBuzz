package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.CricketMatchRequestDto;
import com.example.CricBuzz.model.CricketMatch;

public class CricketMatchConverter {

    public static CricketMatch convertCricketMatchRequestDtoToCricketMatch(CricketMatchRequestDto cricketMatchRequestDto){
        return CricketMatch.builder()
                .title(cricketMatchRequestDto.getTitle())
                .venue(cricketMatchRequestDto.getVenue())
                .noOfOvers(cricketMatchRequestDto.getNoOfOvers())
                .status(cricketMatchRequestDto.getStatus())
                .build();
    }
}
