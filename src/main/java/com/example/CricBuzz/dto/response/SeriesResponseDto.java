package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.enums.Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeriesResponseDto {

    String name;
    Type type;
    LocalDate startDate;
    LocalDate endDate;
}
