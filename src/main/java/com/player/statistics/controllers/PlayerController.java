package com.player.statistics.controllers;

import java.util.List;

import com.player.statistics.models.Player;
import com.player.statistics.serviceses.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/players")
public class PlayerController {
    @Autowired
    PlayerService ps;
    @GetMapping("")
  public String GetPlayers(Model model){
      List<Player> players= ps.getAllPlayers();
      model.addAttribute("players", players);
      return "players";
  }  
  @RequestMapping("{id}/delete")
    public String deleteCoach(@PathVariable Long id){
       ps.delete(id);
       return "redirect:/players";
    }
    
    @RequestMapping("{id}")
    public String editPlayer(Model model, @PathVariable Long id){
        Player player=null;
        if(id==0){
            player=new Player();
           
        }else{
            player=ps.getPlayerById(id);
        }
        model.addAttribute("player", player);
        return "player";
    }

    @PostMapping
    public String savePlayer(@ModelAttribute Player player){
        ps.savePlayer(player);
        return "redirect:players";
    }


}