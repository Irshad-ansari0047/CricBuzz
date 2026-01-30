package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.SeriesRequestDto;
import com.example.CricBuzz.dto.response.SeriesResponseDto;
import com.example.CricBuzz.service.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping("/add")
    public ResponseEntity<SeriesResponseDto> createSeries(@RequestBody SeriesRequestDto seriesRequestDto) {

        return new ResponseEntity<>(seriesService.addSeries(seriesRequestDto), HttpStatus.OK);
    }

    @GetMapping("/find/{seriesId}")
    public ResponseEntity<SeriesResponseDto> getSeries(@PathVariable("seriesId") int seriesId) {

        return new ResponseEntity<>(seriesService.getSeries(seriesId), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<SeriesResponseDto>> getALlSeries() {

        return new ResponseEntity<>(seriesService.getAllSeries(), HttpStatus.OK);
    }

    @PutMapping("/put/{seriesId}")
    public ResponseEntity<SeriesResponseDto> updateSeries(@PathVariable("seriesId") int seriesId,@RequestBody SeriesRequestDto seriesRequestDto) {

        return new ResponseEntity<>(seriesService.updateSeries(seriesId, seriesRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{seriesId}")
    public ResponseEntity<String>  deleteSeries(@PathVariable("seriesId") int seriesId) {
        return new ResponseEntity<>(seriesService.deleteSeries(seriesId),HttpStatus.ACCEPTED);
    }

}
