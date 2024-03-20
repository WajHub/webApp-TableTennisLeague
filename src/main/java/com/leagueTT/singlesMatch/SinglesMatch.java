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
    private Game game;

    @OneToOne
    @JoinColumn(name="IdPlayerHome")
    private Player playerHome;

    @OneToOne
    @JoinColumn(name="IdPlayerGuest")
    private Player playerGuest;
}
