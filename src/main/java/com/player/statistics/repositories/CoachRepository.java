package com.player.statistics.repositories;

import com.player.statistics.models.Coach;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    
}