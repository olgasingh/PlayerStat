package com.player.statistics.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Game {
    private Long id;
    private String name;

    @DateTimeFormat (pattern="MM/dd/YYYY")
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

}