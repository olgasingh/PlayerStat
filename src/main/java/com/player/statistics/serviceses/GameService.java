package com.player.statistics.serviceses;

import java.util.List;

import com.player.statistics.models.Game;
import com.player.statistics.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
  @Autowired
  GameRepository   gameRepo;
  public List<Game> getAllGames(){
  return gameRepo.findAll();
  }
  public void delete(Long id){
    gameRepo.deleteById(id);
    }
    public Game saveGame(Game game){
        return gameRepo.saveAndFlush(game);
        //return gameRepo.save(game);
    }
    public Game getGameById(Long id){
        return gameRepo.findById(id).get();
     }
}
