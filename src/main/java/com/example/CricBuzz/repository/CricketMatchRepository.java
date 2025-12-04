package com.example.CricBuzz.repository;

import com.example.CricBuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketMatchRepository extends JpaRepository<CricketMatch,Integer> {
}
