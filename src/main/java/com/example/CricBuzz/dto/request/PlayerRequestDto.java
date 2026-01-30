package com.example.CricBuzz.dto.request;

import com.example.CricBuzz.enums.Gender;
import com.example.CricBuzz.enums.Speciality;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequestDto {

    String name;

    Gender gender;

    Speciality speciality;

    String email;
}
