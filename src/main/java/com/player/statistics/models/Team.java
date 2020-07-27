package com.player.statistics.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team{
    private Long id;
    private String name;
    private List<Statistic> statistices;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }

    public  String getName(){
        return name;
    }

    public void setId(Long id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    @OneToMany( mappedBy = "team"  )
    public List<Statistic> getStatistices(){
        return statistices;
    }

    public void setStatistices(List<Statistic> statistices){
        this.statistices=statistices;
    }
}