package com.example.CricBuzz.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Team {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column(name = "ranking", unique = true)
    int ranking;

    @Column
    int iccPoints;

    @Column
    String coach;

//    relationship between team and player
    @JsonManagedReference
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    List<Player> playerList;

    //    relationship between team and cricketMatch
    @JsonManagedReference
    @ManyToMany(mappedBy = "teams")
    List<CricketMatch> matches;
}
