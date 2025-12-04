package com.example.CricBuzz.model;

import com.example.CricBuzz.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cricket_match")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CricketMatch {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String title;

    @Column
    String venue;

    @Column
    int noOfOvers;

    @Column
    @CreationTimestamp
    Date createdAt;

    @Column
    @Enumerated(value = EnumType.STRING)
    Status status;

//    relationship between cricketMatch and team
    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "team_match",
    joinColumns = @JoinColumn(name = "cricket_match_id"),
    inverseJoinColumns = @JoinColumn(name = "team_id"))
    List<Team> teams;

//    relationship between cricketMatch and series
    @JsonBackReference
    @ManyToOne
    @JoinColumn
    Series seriesName;
}
