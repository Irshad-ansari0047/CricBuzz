package com.example.CricBuzz.model;

import com.example.CricBuzz.enums.Type;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "series")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Series {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    @Enumerated(value = EnumType.STRING)
    Type type;

    @Column
    LocalDate startDate;

    @Column
    LocalDate endDate;

//    relationship betweeen series and cricketmatch
    @JsonManagedReference
    @OneToMany(mappedBy = "seriesName",cascade = CascadeType.ALL)
    List<CricketMatch> matches;
}
