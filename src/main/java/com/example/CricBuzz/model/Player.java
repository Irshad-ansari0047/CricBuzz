package com.example.CricBuzz.model;

import com.example.CricBuzz.enums.Gender;
import com.example.CricBuzz.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Player {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @Column
    @Enumerated(value = EnumType.STRING)
    Speciality speciality;

    @Column(nullable = false,unique = true)
    String email;

//    relationship between player and playerProfile
    @JsonManagedReference
    @OneToOne(mappedBy = "player",cascade = CascadeType.ALL)
    PlayerProfile playerProfile;

//    relationship between player and team
    @JsonBackReference
    @ManyToOne
    @JoinColumn
    Team team;
}
