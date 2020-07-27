package com.player.statistics.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Player {
  private Long id;
  private String firstname;
  private String lastname;
  private List<Statistic> statistices; 
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    } 
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    @OneToMany( mappedBy = "player"  )
    public List<Statistic> getStatistices(){
        return statistices;
    }

    public void setStatistices(List<Statistic> statistices){
        this.statistices=statistices;
    }



}