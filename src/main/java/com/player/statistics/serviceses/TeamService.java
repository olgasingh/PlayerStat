package com.player.statistics.serviceses;


import java.util.List;

import com.player.statistics.models.Team;
import com.player.statistics.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
 
    @Autowired
    TeamRepository teamRepo;

    public List<Team> getAllTeams(){
        return teamRepo.findAll();

    }

    public void delete(Long id){
        teamRepo.deleteById(id);
    }
    public Team saveTeam(Team team){
        return teamRepo.save(team);
    }

    public Team getTeamById(Long id){
       return teamRepo.findById(id).get();
    }
}