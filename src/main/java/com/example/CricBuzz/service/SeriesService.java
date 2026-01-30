package com.example.CricBuzz.service;

import com.example.CricBuzz.converter.SeriesConverter;
import com.example.CricBuzz.dto.request.SeriesRequestDto;
import com.example.CricBuzz.dto.response.SeriesResponseDto;
import com.example.CricBuzz.model.Series;
import com.example.CricBuzz.repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public SeriesResponseDto addSeries(SeriesRequestDto seriesRequestDto) {

        Series series = SeriesConverter.convertSeriesRequestDtoToSeries(seriesRequestDto);
        Series saved = seriesRepository.save(series);

        return SeriesConverter.convertSeriesToSeriesResponseDto(saved);
    }

    public SeriesResponseDto getSeries(int seriesId) {

        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new RuntimeException("Series not found"));

        return SeriesConverter.convertSeriesToSeriesResponseDto(series);
    }

    public List<SeriesResponseDto> getAllSeries() {

        List<Series> seriesList = seriesRepository.findAll();

        List<SeriesResponseDto> seriesResponseDtoList = new ArrayList<>();

        for (Series series : seriesList) {
            seriesResponseDtoList.add(SeriesConverter.convertSeriesToSeriesResponseDto(series));
        }
        return seriesResponseDtoList;
    }

    public SeriesResponseDto updateSeries(int seriesId, SeriesRequestDto seriesRequestDto) {

        Series series = seriesRepository.findById(seriesId)
                .orElseThrow(() -> new RuntimeException("Series not found"));

        series.setName(seriesRequestDto.getName());
        series.setType(seriesRequestDto.getType());
        series.setStartDate(seriesRequestDto.getStartDate());
        series.setEndDate(seriesRequestDto.getEndDate());

        Series savedSeries = seriesRepository.save(series);

        return SeriesConverter.convertSeriesToSeriesResponseDto(savedSeries);
    }

    public String deleteSeries(int seriesId) {

        if(!seriesRepository.existsById(seriesId)) {
            throw new RuntimeException("Series not found");
        }
        seriesRepository.deleteById(seriesId);
        return "Series deleted";
    }
}
