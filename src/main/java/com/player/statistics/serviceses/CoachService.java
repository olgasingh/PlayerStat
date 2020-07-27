package com.player.statistics.serviceses;

import java.util.List;

import com.player.statistics.models.Coach;
import com.player.statistics.repositories.CoachRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
 
    @Autowired
    CoachRepository coachRepo;

    public List<Coach> getAllCoachs(){
        
        return coachRepo.findAll();

    }

    public void delete(Long id){
        coachRepo.deleteById(id);
    }
    public Coach saveCoach(Coach coach){
        return coachRepo.save(coach);
    }

    public Coach getCoachById(Long id){
       return coachRepo.findById(id).get();
    }
}
