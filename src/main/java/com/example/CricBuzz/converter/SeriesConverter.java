package com.example.CricBuzz.converter;

import com.example.CricBuzz.dto.request.SeriesRequestDto;
import com.example.CricBuzz.model.Series;

public class SeriesConverter {

    public static Series convertSeriesRequestDtoToSeries(SeriesRequestDto seriesRequestDto){
        return Series.builder()
                .name(seriesRequestDto.getName())
                .type(seriesRequestDto.getType())
                .startDate(seriesRequestDto.getStartDate())
                .endDate(seriesRequestDto.getEndDate())
                .build();
    }
}
