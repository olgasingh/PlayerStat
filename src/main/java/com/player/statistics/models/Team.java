package com.player.statistics.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team{
    private Long id;
    private String name;

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
}