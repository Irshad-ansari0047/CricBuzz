package com.example.CricBuzz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_profile")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlayerProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    int matchesPlayed;

    @Column
    int runsScored;

    @Column
    int wicketsTaken;

    @Column
    double battingAvg;

    @Column
    double bowlingAvg;

//    relationship between player and playerProfile
    @JsonBackReference
    @OneToOne
    @JoinColumn
    Player player;
}
