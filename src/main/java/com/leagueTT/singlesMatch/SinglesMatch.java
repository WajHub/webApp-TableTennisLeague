package com.leagueTT.singlesMatch;

import com.leagueTT.game.Game;
import com.leagueTT.player.Player;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class SinglesMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;

    @Column(name = "ResultPlayerHome")
    private Integer resultPlayerHome;

    @Column(name = "ResultPlayerGuest")
    private Integer resultPlayerGuest;

    @ManyToOne
    @JoinColumn(name="IdGame")
    private Long game;

    @OneToOne
    @JoinColumn(name="IdPlayerHome")
    private Long playerHome;

    @OneToOne
    @JoinColumn(name="IdPlayerGuest")
    private Long playerGuest;

    public SinglesMatch(Integer resultPlayerHome, Integer resultPlayerGuest, Long game, Long playerHome, Long playerGuest) {
        this.resultPlayerHome = resultPlayerHome;
        this.resultPlayerGuest = resultPlayerGuest;
        this.game = game;
        this.playerHome = playerHome;
        this.playerGuest = playerGuest;
    }
}
