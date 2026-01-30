package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatchResponseDto {

    String title;
    String venue;
    int noOfOvers;
    Date createdAt;
    Status status;

    String seriesName;
    List<TeamResponseDto> teams;
}
