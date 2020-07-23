package com.player.statistics.controllers;

import java.util.List;

import com.player.statistics.models.Team;
import com.player.statistics.serviceses.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/teams")
public class TeamController {

    @Autowired
    TeamService ts;

    @GetMapping("")
    public String getTeams(Model model) {
        List<Team> teams=ts.getAllTeams();
        model.addAttribute("teams",teams);
        return "teams";
    }

    @RequestMapping("{id}/delete")
    public String deleteTaem(@PathVariable Long id){
       ts.delete(id);
       return "redirect:/teams";
    }
    
    @RequestMapping("{id}")
    public String editTeam(Model model, @PathVariable Long id){
        Team team=null;
        if(id==0){
            team=new Team();
           
        }else{
            team=ts.getTeamById(id);
        }
        model.addAttribute("team", team);
        return "team";
    }

    @PostMapping
    public String saveTeam(@ModelAttribute Team team ){
        ts.saveTeam(team);
        return "redirect:teams";
    }



}