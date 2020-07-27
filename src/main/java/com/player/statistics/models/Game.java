package com.player.statistics.models;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Game {
    private Long id;
    private String name;

    private List<Statistic> statistices = new ArrayList<Statistic>();

   //@DateTimeFormat (pattern="MM/dd/YYYY")
   //@Temporal(TemporalType.DATE)
    private Date gamedate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name ;
    }

    public Date getGamedate() {
        return gamedate;
    }

    public void setId(Long id) {
        this.id = id ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGamedate(Date gamedate) {
        this.gamedate = gamedate;

    }

    @OneToMany( mappedBy = "game", cascade = CascadeType.ALL )
    public List<Statistic> getStatistices(){
        return statistices;
    }

    public void setStatistices(List<Statistic> statistices){
        this.statistices=statistices;
    }

}