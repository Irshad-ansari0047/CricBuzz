package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.SeriesRequestDto;
import com.example.CricBuzz.dto.response.SeriesResponseDto;
import com.example.CricBuzz.dto.response.TeamResponseDto;
import com.example.CricBuzz.model.Series;
import com.example.CricBuzz.model.Team;

public class SeriesConverter {

    public static Series convertSeriesRequestDtoToSeries(SeriesRequestDto seriesRequestDto){
        return Series.builder()
                .name(seriesRequestDto.getName())
                .type(seriesRequestDto.getType())
                .startDate(seriesRequestDto.getStartDate())
                .endDate(seriesRequestDto.getEndDate())
                .build();
    }

    public static SeriesResponseDto convertSeriesToSeriesResponseDto(Series series){

        return SeriesResponseDto.builder()
                .name(series.getName())
                .type(series.getType())
                .startDate(series.getStartDate())
                .endDate(series.getEndDate())
                .build();
    }
}
