package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.enums.Gender;
import com.example.CricBuzz.enums.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerResponseDto {

    String name;

    Gender gender;

    Speciality speciality;

}
