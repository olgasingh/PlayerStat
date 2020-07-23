package com.player.statistics.repositories;

import com.player.statistics.models.Game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}