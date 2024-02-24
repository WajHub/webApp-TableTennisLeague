package com.leagueTT.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Game game){
        jdbcTemplate.update("INSERT INTO Game(round, dateOfMatch, numberOfSUpporters, resultHome, resultGuest, idHome, idGuest)" +
                "VALUES(?,?,?,?,?,?,?)",game.getRound(),game.getDateOfMatch(),game.getNumberOfSupporters(),game.getResultHome(),
                game.getResultGuest(),game.getIdHome(),game.getIdGuest());
        return 1;
    }
}
