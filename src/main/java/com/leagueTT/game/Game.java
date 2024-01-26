package com.leagueTT.game;

import com.leagueTT.team.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name = "Round", nullable = false)
    private int round;

    @Column(name = "DateOfMatch", nullable = false)
    private Date dateOfMatch;

    @Column(name = "NumberOfSupporters")
    private Integer numberOfSupporters;

    @Column(name = "ResultHome")
    private Integer resultHome;

    @Column(name = "ResultGuest")
    private Integer resultGuest;

    @ManyToOne
    @JoinColumn(name="IdHome")
    private Team idHome;

    @ManyToOne
    @JoinColumn(name="IdGuest")
    private Team idGuest;
}
