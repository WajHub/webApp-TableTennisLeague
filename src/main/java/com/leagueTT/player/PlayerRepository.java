package com.leagueTT.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getPlayers(){
        String sql = "Select p.*, th.* FROM Player p " +
                "LEFT JOIN Team th ON p.IdTeam=th.Id";
        return jdbcTemplate.query(sql, new PlayerRowMapper());
    }

    public Player getPlayer(int idPlayer) {
        String sql = "Select p.*, th.* FROM Player p " +
                "LEFT JOIN Team th ON p.IdTeam=th.Id " +
                "WHERE p.Id=?";
        return (Player) jdbcTemplate.queryForObject(sql, new PlayerRowMapper(), idPlayer);
    }
}
