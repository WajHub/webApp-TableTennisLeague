package com.leagueTT.team;

import com.leagueTT.hall.Hall;
import com.leagueTT.player.Player;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;

@Data
@Entity
@Table(name="Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name="NameT",nullable = false)
    private String nameT;

    @Column(name="YearOfFundation",nullable = false)
    @Check(constraints = "yearOfFundation > 0")
    private Integer yearOfFundation;

    @Column(name = "Tables")
    private String tables;
    @Column(name = "Balls")
    private String balls;

    @Column(name="LogoURL",nullable = false)
    private String logoURL;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "IdHall")
    private Hall hall;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PeselCaptain")
    private Player player;

    private int numberOfMatches;

    private int numberOfWins;

    private int numberOfLosses;

    private int numberOfPoints;

    public Team(String nameT, Integer  yearOfFundation, String tables, String balls, String logoURL, Hall hall, Player player) {
        this.nameT = nameT;
        this.yearOfFundation = yearOfFundation;
        this.tables = tables;
        this.balls = balls;
        this.logoURL = logoURL;
        this.hall = hall;
        this.player = player;
    }

    public Team() {

    }
}
