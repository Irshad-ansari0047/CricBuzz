package com.example.CricBuzz.repository;

import com.example.CricBuzz.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<PlayerProfile,Integer> {
}
