package com.player.statistics.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Statistic {
    private Long id;
    @MapsId
    private Game game; 
    private Player player;
    private Team team;
    private Coach coach;
    private int point;
    private int rpoint;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="gameid", referencedColumnName = "id")
    public Game getGame(){
        return game;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="playerid")
    public Player getPlayer(){
        return player;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teamid")
    public Team getTeam(){
        return team;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coachid")
    public Coach getCoach(){
        return coach;
    }
    
    public int getPoint(){
        return point;
    }
    public int getRpoint(){
        return rpoint;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setGame(Game game){
        this.game=game;
    }
    public void setPlayer(Player player){
        this.player=player;
    }
    public void setTeam(Team team){
        this.team=team;
    }
    public void setCoach(Coach coach){
        this.coach=coach;
    }
    public void setPoint(int point){
        this.point=point;
    }
    public void setRpoint(int rpoint){
        this.rpoint=rpoint;
    }
}