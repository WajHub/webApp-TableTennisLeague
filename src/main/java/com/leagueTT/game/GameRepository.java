package com.leagueTT.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Game game){
        jdbcTemplate.update("INSERT INTO Game(round, dateOfMatch, numberOfSUpporters, resultHome, resultGuest, idHome, idGuest)" +
                "VALUES(?,?,?,?,?,?,?)",game.getRound(),game.getDateOfMatch(),game.getNumberOfSupporters(),game.getResultHome(),
                game.getResultGuest(),game.getTeamHome(),game.getTeamGuest());
        return 1;
    }

    public List getAllGames(){
        String sql = "SELECT g.*, th.*, tg.* " +
                "FROM Game g " +
                "LEFT JOIN Team th ON g.IdHome = th.Id " +
                "LEFT JOIN Team tg ON g.IdGuest = tg.Id " ;
        return jdbcTemplate.query(sql, new GameRowMapper());
    }
}
