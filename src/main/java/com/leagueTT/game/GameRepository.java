package com.leagueTT.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRepository {


    JdbcTemplate jdbcTemplate;

    @Autowired
    public GameRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    public int delete(int id) {
        String sql = "DELETE FROM Game WHERE Id=?";
        return jdbcTemplate.update(sql, id);
    }

    public Game getGame(long id) {
        String sql = "SELECT g.*, th.*, tg.* " +
                "FROM Game g " +
                "LEFT JOIN Team th ON g.IdHome = th.Id " +
                "LEFT JOIN Team tg ON g.IdGuest = tg.Id " +
                "WHERE g.id = ?" ;
        return (Game) jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Game.class), id);
    }

    public int incrementResultHome(long gameId){
        String sql = "UPDATE Game " +
                        "SET ResultHome=ResultHome+1 " +
                        "WHERE Game.id = ?";
        jdbcTemplate.update(sql, gameId);
        return 1;
    }

    public int incrementResultGuest(long gameId){
        String sql = "UPDATE Game " +
                "SET ResultGuest=ResultGuest+1 " +
                "WHERE Game.id = ?";
        jdbcTemplate.update(sql, gameId);
        return 1;
    }
}
