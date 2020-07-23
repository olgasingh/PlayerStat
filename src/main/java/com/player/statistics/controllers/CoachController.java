package com.player.statistics.controllers;

import java.util.List;

import com.player.statistics.models.Coach;
import com.player.statistics.serviceses.CoachService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/coachs")
public class CoachController {
    @Autowired
    CoachService cs;

    @GetMapping("")
    public String getCoachs(Model model) {
        List<Coach> coachs=cs.getAllCoachs();
        model.addAttribute("coachs",coachs);
        return "coachs";
    } 
    @RequestMapping("{id}/delete")
    public String deleteCoach(@PathVariable Long id){
       cs.delete(id);
       return "redirect:/coachs";
    }
    
    @RequestMapping("{id}")
    public String editCoach(Model model, @PathVariable Long id){
        Coach coach=null;
        if(id==0){
            coach=new Coach();
           
        }else{
            coach=cs.getCoachById(id);
        }
        model.addAttribute("coach", coach);
        return "coach";
    }

    @PostMapping
    public String saveCoach(@ModelAttribute Coach coach){
        cs.saveCoach(coach);
        return "redirect:coachs";
    }


 
}