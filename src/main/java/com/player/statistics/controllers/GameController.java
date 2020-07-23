package com.player.statistics.controllers;

import java.util.List;

import com.player.statistics.models.Game;
import com.player.statistics.serviceses.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/games")
public class GameController {
    @Autowired
    GameService gs;
    @GetMapping("")
  public String GetGames(Model model){
      List<Game> games= gs.getAllGames();
      model.addAttribute("games", games);
      return "games";
  } 
  @RequestMapping("{id}/delete")
    public String deleteGame(@PathVariable Long id){
       gs.delete(id);
       return "redirect:/games";
    } 
    @RequestMapping("{id}")
    public String editGame(Model model, @PathVariable Long id){
        Game game=null;
        if(id==0){
            game=new Game();
           
        }else{
            game=gs.getGameById(id);
        }
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping
    public String saveGame(@ModelAttribute Game game){
        gs.saveGame(game);
        return "redirect:games";
    }
   
}