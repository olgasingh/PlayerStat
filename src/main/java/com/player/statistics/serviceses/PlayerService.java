package com.player.statistics.serviceses;

import java.util.List;

import com.player.statistics.models.Player;
import com.player.statistics.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlayerService {
  @Autowired
  PlayerRepository  playerRepo;
  public List<Player> getAllPlayers(){
    return playerRepo.findAll();
    }
  public void delete(Long id){
    playerRepo.deleteById(id);
    }
    public Player savePlayer(Player player){
        return playerRepo.save(player);
    }

    public Player getPlayerById(Long id){
       return playerRepo.findById(id).get();
    }
}