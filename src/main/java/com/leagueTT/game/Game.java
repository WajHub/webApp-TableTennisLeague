package com.leagueTT.game;

import com.leagueTT.team.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name = "Round", nullable = false)
    private int round;

    @Column(name = "DateOfMatch", nullable = false)
    private LocalDate dateOfMatch;

    @Column(name = "NumberOfSupporters")
    private Integer numberOfSupporters;

    @Column(name = "ResultHome")
    private Integer resultHome;

    @Column(name = "ResultGuest")
    private Integer resultGuest;

    @ManyToOne
    @JoinColumn(name="IdHome")
    private Long teamHome;

    @ManyToOne
    @JoinColumn(name="IdGuest")
    private Long teamGuest;

    public Game(int round, LocalDate dateOfMatch, Integer numberOfSupporters, Integer resultHome, Integer resultGuest, Long teamHome, Long teamGuest) {
        this.round = round;
        this.dateOfMatch = dateOfMatch;
        this.numberOfSupporters = numberOfSupporters;
        this.resultHome = resultHome;
        this.resultGuest = resultGuest;
        this.teamHome = teamHome;
        this.teamGuest = teamGuest;
    }

    public Game() {
    }
}
